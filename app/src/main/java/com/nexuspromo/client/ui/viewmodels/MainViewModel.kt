package com.nexuspromo.client.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexuspromo.client.data.model.PromoResponse
import com.nexuspromo.client.data.repository.PromoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val promoRepository: PromoRepository
) : ViewModel() {
    private val TAG = MainViewModel::class.java.simpleName

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isFail = MutableStateFlow<Boolean>(false)
    val isFail: StateFlow<Boolean> = _isFail

    private val _promoResponse = MutableStateFlow<PromoResponse>(PromoResponse())
    val promoResponse: StateFlow<PromoResponse> = _promoResponse

    init {
        fetchData()
    }

    private fun fetchData() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = promoRepository.getPromos()
                Log.d(TAG, "response: $response")
                _promoResponse.value = response
            } catch (e: Exception) {
                _isLoading.value = false
                _isFail.value = true
            } finally {
                _isLoading.value = false
                _isFail.value = false
            }
        }
    }
}
