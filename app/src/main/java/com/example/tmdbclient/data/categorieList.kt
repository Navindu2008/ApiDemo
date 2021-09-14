package com.example.tmdbclient.data


import com.google.gson.annotations.SerializedName

data class category  (
    @SerializedName ("category")
    val category: List<String>
)