package com.elv.myappmovil02.hilt

class GetProducUseCase {
    private  val repository = ProductRepository()

    suspend operator fun invoke(): ProductModel? {
        return repository.getAllProducts()
    }

}