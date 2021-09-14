package com.example.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class ProductList (
    @SerializedName ("products")
    val product: List<ProductListItem>

)