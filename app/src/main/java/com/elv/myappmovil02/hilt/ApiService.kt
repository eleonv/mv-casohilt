package com.elv.myappmovil02.hilt

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    /* https://fakestoreapi.com/products/1
    */
    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") idProduct: Int
    ): Response<ProductModel>
}