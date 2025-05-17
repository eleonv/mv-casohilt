package com.elv.myappmovil02.hilt

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val apiService: ApiService,
    //private val provider: ProductProvider
) {
   suspend fun getProductFromApi(productId: Int): ProductModel? {
       try {
           val response = apiService.getProductById(productId)
           if (response.isSuccessful) {
               return response.body() // Retorna el ProductModel si la llamada fue exitosa (código 2xx)
           } else {
               // Manejar errores de API (ej. log, lanzar excepción específica)
               Log.e("ProductRepository", "Error API: ${response.code()} - ${response.message()}")
               return null
           }
       } catch (e: Exception) {
           // Manejar excepciones de red (ej. no hay conexión)
           Log.e("ProductRepository", "Excepción de red: ${e.message}", e)
           return null
       }

       /*val response = apiService.getProductById(1)
       provider.productos = response
       return response!!*/
   }

}