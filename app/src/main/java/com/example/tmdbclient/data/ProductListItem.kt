package com.example.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class ProductListItem(
    @SerializedName("category")
    val category: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String?,
    @SerializedName("price")
    val price: String,
    @SerializedName("title")
    val title: String?
)