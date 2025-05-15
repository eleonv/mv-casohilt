package com.elv.myappmovil02.hilt

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {
    private val retrofit = RetrofitHelper.getRetrofit()
    private val apiClient = retrofit.create(ProductApiClient::class.java)

    suspend fun getProductById(idProduct: Int): ProductModel? {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiClient.getProductById(idProduct) // Usar el apiClient inyectado
                if (response.isSuccessful) {
                    response.body()
                } else {
                    // Log error
                    null
                }
            } catch (e: Exception) {
                // Log exception
                null
            }
        }
    }
}