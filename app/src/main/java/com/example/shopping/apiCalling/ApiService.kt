package com.example.shopping.apiCalling

import com.example.shopping.ProductResponce
import retrofit2.http.GET


interface ApiService {

    @GET("products")
    suspend fun getProducts(): ProductResponce
}