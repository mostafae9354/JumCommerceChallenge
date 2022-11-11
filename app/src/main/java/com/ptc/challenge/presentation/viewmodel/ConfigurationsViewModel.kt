package com.ptc.challenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ptc.challenge.data.source.preference.PreferenceStore
import com.ptc.challenge.domain.entity.GetConfigurationsResponseEntity
import com.ptc.challenge.domain.usecase.GetConfigurationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigurationsViewModel @Inject constructor(
    private val getConfigurationsUseCase: GetConfigurationsUseCase,
    private val preferenceStore: PreferenceStore
) : ViewModel() {

    private val _configurationsLiveData = MutableStateFlow<GetConfigurationsResponseEntity?>(null)
    fun configurationsLiveData(): StateFlow<GetConfigurationsResponseEntity?> =
        _configurationsLiveData

    private val _errorLiveData = MutableStateFlow<Throwable?>(null)
    fun errorLiveData(): StateFlow<Throwable?> = _errorLiveData

    private val _loadingLiveData = MutableStateFlow(false)
    fun loadingLiveData(): StateFlow<Boolean> = _loadingLiveData

    fun loadConfigurations() {
        viewModelScope.launch(Dispatchers.IO) {

            _loadingLiveData.emit(true)
            try {

                getConfigurationsUseCase().let {

                    _loadingLiveData.emit(false)
                    onGetConfigurationsSuccess(it)
                }
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    private fun onGetConfigurationsSuccess(response: GetConfigurationsResponseEntity) {

        preferenceStore.setConfigurations(response)
        _configurationsLiveData.value = response
    }

    private fun onError(error: Throwable) {
        _errorLiveData.value = error
    }
}