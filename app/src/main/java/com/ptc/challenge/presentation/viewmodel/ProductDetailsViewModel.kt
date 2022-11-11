package com.ptc.challenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ptc.challenge.domain.entity.GetProductDetailsResponseEntity
import com.ptc.challenge.domain.entity.param.GetProductDetailsParam
import com.ptc.challenge.domain.usecase.GetProductDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) : ViewModel() {

    private val _productDetailsLiveData = MutableStateFlow<GetProductDetailsResponseEntity?>(null)
    fun productDetailsLiveData(): StateFlow<GetProductDetailsResponseEntity?> =
        _productDetailsLiveData

    private val _errorLiveData = MutableStateFlow<Throwable?>(null)
    fun errorLiveData(): StateFlow<Throwable?> = _errorLiveData

    private val _loadingLiveData = MutableStateFlow(false)
    fun loadingLiveData(): StateFlow<Boolean> = _loadingLiveData

    fun loadProductDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {

            _loadingLiveData.emit(true)
            try {

                getProductDetailsUseCase(GetProductDetailsParam(id)).let {

                    _loadingLiveData.emit(false)
                    onGetConfigurationsSuccess(it)
                }
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    private fun onGetConfigurationsSuccess(response: GetProductDetailsResponseEntity) {

        _productDetailsLiveData.value = response
    }

    private fun onError(error: Throwable) {
        _errorLiveData.value = error
    }
}