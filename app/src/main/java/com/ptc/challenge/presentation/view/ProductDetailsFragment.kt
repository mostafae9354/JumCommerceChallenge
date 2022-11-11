package com.ptc.challenge.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.denzcoskun.imageslider.models.SlideModel
import com.ptc.challenge.R
import com.ptc.challenge.data.source.preference.PreferenceStore
import com.ptc.challenge.databinding.FragmentProductDetailsBinding
import com.ptc.challenge.domain.entity.CurrencyEntity
import com.ptc.challenge.presentation.adapter.ProductsAdapter
import com.ptc.challenge.presentation.uimodel.ProductUiModel
import com.ptc.challenge.presentation.viewmodel.ProductDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailsFragment : Fragment(), ProductsAdapter.OnItemClickListener {

    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel by viewModels<ProductDetailsViewModel>()
    private var currencyEntity: CurrencyEntity? = null

    @Inject
    lateinit var preferenceStore: PreferenceStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currencyEntity = preferenceStore.getConfigurations()?.metadata?.currency

        arguments?.getInt(PRODUCT_ID)?.let { viewModel.loadProductDetails(it) }
        arguments?.getString(PRODUCT_BRAND)?.let { activity?.title = it }
        observeViewModel()
    }

    private fun observeViewModel() {

        lifecycleScope.launchWhenStarted {

            launch {

                viewModel.productDetailsLiveData().collect {
                    if (it != null) {
                        val imageList = ArrayList<SlideModel>()
                        // Create image list
                        for (imageUrl in it.metadata?.imagesList ?: emptyList()) {
                            imageList.add(SlideModel(imageUrl))
                        }
                        binding.isProductImages.setImageList(imageList)
                        binding.productDetails = it
                        binding.tvProductSpecialPrice.text =
                            "${currencyEntity?.symbol} ${it.metadata?.specialPrice}"
                        binding.tvProductPrice.text =
                            "${currencyEntity?.symbol} ${it.metadata?.price}"
                    }
                }
            }

            launch {

                viewModel.errorLiveData().collect {
                    if (it != null) {
                        Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
                        it.printStackTrace()
                    }
                }
            }
        }
    }

    companion object {
        private const val PRODUCT_ID = "ID"
        private const val PRODUCT_BRAND = "brand"

        @JvmStatic
        fun newInstance(id: Int, brand: String): ProductDetailsFragment =
            ProductDetailsFragment().apply {
                arguments = bundleOf(
                    PRODUCT_ID to id,
                    PRODUCT_BRAND to brand
                )
            }
    }

    override fun onItemClicked(productUiModel: ProductUiModel) {
        Toast.makeText(requireContext(), productUiModel.name, Toast.LENGTH_SHORT).show()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.title = getString(R.string.app_name)
    }
}