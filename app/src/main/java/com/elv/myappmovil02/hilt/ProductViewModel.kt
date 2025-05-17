package com.elv.myappmovil02.hilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val producUseCase: GetProducUseCase
) : ViewModel() {

    /*var productModel = MutableLiveData<ProductModel?>()
    //val producUseCase = GetProducUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = producUseCase()
            if (result != null) {
                productModel.postValue(result)
            }
        }
    }*/

    private val _productState = MutableLiveData<UiState<ProductModel?>>() // El producto puede ser nulo
    val productState: LiveData<UiState<ProductModel?>> = _productState

    fun onCreate() {

        _productState.value = UiState.Loading

        viewModelScope.launch {
            try {
                // Ahora el UseCase podría necesitar un parámetro como productId
                val productId = 1;
                val result = producUseCase(productId)
                //val result = getProductUseCase(productId)
                if (result != null) {
                    _productState.value = UiState.Success(result)
                } else {
                    _productState.value = UiState.Error("Producto no encontrado (ID: $productId)")
                }
            } catch (e: Exception) {
                // Captura excepciones más generales que podrían ocurrir en el flujo (aunque el repo ya maneja algunas)
                _productState.value = UiState.Error("Error al cargar el producto: ${e.message}")
            }
        }
    }
}