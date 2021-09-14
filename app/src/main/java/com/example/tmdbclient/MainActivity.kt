package com.example.tmdbclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tmdbclient.Api.ProductService
import com.example.tmdbclient.data.ProductList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://fakestoreapi.com/";
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getProductList();

    }

    private fun getProductList(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ProductService::class.java)


        val retrofitData = retrofitBuilder.getProductList();

        retrofitData.enqueue(object : Callback<List<ProductList>?> {
            override fun onResponse(
                call: Call<List<ProductList>?>,
                response: Response<List<ProductList>?>
            ) {
                val responeBody = response.body()!!

                val stringBuilder = StringBuffer()
                for (myData in responeBody){
                    stringBuilder.append(myData.product[0].description)
                    stringBuilder.append("\n")
                }

                txtId.text= stringBuilder
            }

            override fun onFailure(call: Call<List<ProductList>?>, t: Throwable) {
                Log.d("MainAcitivityTag","OnFailuer" + t.message)
            }
        })

    }
}