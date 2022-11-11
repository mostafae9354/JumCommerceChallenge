package com.ptc.challenge.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ptc.challenge.R
import com.ptc.challenge.core.utils.PaginationScrollListener
import com.ptc.challenge.data.source.preference.PreferenceStore
import com.ptc.challenge.databinding.FragmentProductsListBinding
import com.ptc.challenge.domain.entity.CurrencyEntity
import com.ptc.challenge.presentation.adapter.ProductsAdapter
import com.ptc.challenge.presentation.uimodel.ProductUiModel
import com.ptc.challenge.presentation.uimodel.mapper.toUiModel
import com.ptc.challenge.presentation.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductsListFragment : Fragment(), ProductsAdapter.OnItemClickListener {

    private lateinit var binding: FragmentProductsListBinding
    private val viewModel by viewModels<ProductsViewModel>()
    private lateinit var adapter: ProductsAdapter
    private var currencyEntity: CurrencyEntity? = null

    @Inject
    lateinit var preferenceStore: PreferenceStore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_products_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyEntity = preferenceStore.getConfigurations()?.metadata?.currency

        observeViewModel()
        setupUI()
    }

    private fun setupUI() {
        binding.rvProducts.layoutManager = GridLayoutManager(context, 2)
        binding.rvProducts.setHasFixedSize(true)
        adapter = ProductsAdapter()
        adapter.setOnItemClickListener(this@ProductsListFragment)
        binding.rvProducts.adapter = adapter

        binding.rvProducts.addOnScrollListener(object :
            PaginationScrollListener(binding.rvProducts.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return viewModel.isLastPage
            }

            override fun isLoading(): Boolean {
                return viewModel.isLoading
            }

            override fun loadMoreItems() {
                viewModel.getMoreProducts()
            }
        })
    }

    private fun observeViewModel() {

        viewModel.productsListLiveData().observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()) {
                binding.rvProducts.visibility = View.VISIBLE
            } else {
                binding.rvProducts.visibility = View.GONE
            }
            adapter.submitList(ArrayList(list.map { it.toUiModel(currencyEntity?.symbol) }))
        }

        viewModel.errorLiveData().observe(viewLifecycleOwner) {
            Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
            it.printStackTrace()
        }

        viewModel.loadingLiveData().observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }
    }

    fun search(text: String) {
        viewModel.search(text.trim())
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductsListFragment()
    }

    override fun onItemClicked(productUiModel: ProductUiModel) {
        requireActivity().supportFragmentManager.beginTransaction()
            .add(
                R.id.fl_repos,
                ProductDetailsFragment.newInstance(
                    productUiModel.id ?: 0,
                    productUiModel.brand ?: ""
                ),
                "ProductsListFragment"
            )
            .addToBackStack("ProductsListFragment")
            .commit()
    }
}