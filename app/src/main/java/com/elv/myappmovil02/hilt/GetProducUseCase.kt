package com.elv.myappmovil02.hilt

import javax.inject.Inject


class GetProducUseCase @Inject constructor(
    private val repository: ProductRepository
    //private val provider: ProductProvider
)  {
    suspend operator fun invoke(productId: Int): ProductModel? {
        return repository.getProductFromApi(productId)
    }

}