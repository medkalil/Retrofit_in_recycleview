package com.example.android.retrofitinrecycleview.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(BaseUrl:String) : Retrofit{
        if(retrofit==null){

            retrofit=Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return  retrofit!!
    }

}