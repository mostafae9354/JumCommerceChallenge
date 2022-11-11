package com.ptc.challenge.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.ptc.challenge.core.base.BaseViewModel
import com.ptc.challenge.core.di.qualifier.IoScheduler
import com.ptc.challenge.core.di.qualifier.MainScheduler
import com.ptc.challenge.core.livedata.SingleLiveEvent
import com.ptc.challenge.domain.entity.GetProductsListResponseEntity
import com.ptc.challenge.domain.entity.ProductEntity
import com.ptc.challenge.domain.entity.param.GetProductsListParam
import com.ptc.challenge.domain.usecase.GetProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsListUseCase: GetProductsListUseCase,
    @MainScheduler private val mainScheduler: Scheduler,
    @IoScheduler private val ioScheduler: Scheduler
) : BaseViewModel() {

    var isLoading = false
    var isLastPage = false

    private var page = 0
    private var searchText: String = ""
    private val productsList = arrayListOf<ProductEntity>()

    private val _productsListLiveData = SingleLiveEvent<List<ProductEntity>>()
    fun productsListLiveData(): LiveData<List<ProductEntity>> = _productsListLiveData

    private val _errorLiveData = SingleLiveEvent<Throwable>()
    fun errorLiveData(): LiveData<Throwable> = _errorLiveData

    private val _loadingLiveData = SingleLiveEvent<Boolean>()
    fun loadingLiveData(): LiveData<Boolean> = _loadingLiveData

    fun search(text: String) {
        page = 0
        searchText = text
        productsList.clear()
        _productsListLiveData.value = productsList
        getMoreProducts()
    }

    fun getMoreProducts() {
        getProductsListUseCase(GetProductsListParam(++page, searchText))
            .doOnSubscribe {
                isLoading = true
                _loadingLiveData.postValue(true)
            }
            .doOnTerminate {
                isLoading = false
                _loadingLiveData.postValue(false)
            }
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .subscribe(::onGetProductsSuccess, ::onError)
            .addTo(compositeDisposable)
    }

    private fun onGetProductsSuccess(response: GetProductsListResponseEntity) {

        productsList.addAll(response.metadata?.results ?: listOf())
        if (productsList.size == (response.metadata?.totalProducts ?: 0))
            isLastPage = true
        _productsListLiveData.value = productsList
    }
    
    private fun onError(error: Throwable) {
        _errorLiveData.value = error
    }
}