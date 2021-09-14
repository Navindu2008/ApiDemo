package com.example.tmdbclient.Api

import com.example.tmdbclient.data.ProductList
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products")
      fun  getProductList() : Call<List<ProductList>>

}