package com.example.shopping

data class Product(
    val title: String,
    val price : Double,
    val image : List<Product>,
    val thumbnail : String,
    val category: String,
    val description : String
)
