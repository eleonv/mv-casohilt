package com.elv.myappmovil02.hilt

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    var productModel = MutableLiveData<ProductModel?>()
    val producUseCase = GetProducUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = producUseCase()
            if (result != null) {
                productModel.postValue(result)
            }
        }
    }
}