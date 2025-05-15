package com.elv.myappmovil02.hilt

class ProductRepository {

    private val api = ProductService()

    suspend fun getAllQuotes(): ProductModel {
        val response = api.getProductById(1)
        ProductProvider.productos = response
        return response!!
    }
}