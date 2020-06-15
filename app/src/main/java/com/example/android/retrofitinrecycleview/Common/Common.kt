package com.example.android.retrofitinrecycleview.Common

import com.example.android.retrofitinrecycleview.Retrofit.RetrofitClient
import com.example.android.retrofitinrecycleview.Retrofit.RetrofitService
import retrofit2.create

object Common {
    private val BaseUrl = "https://jsonplaceholder.typicode.com/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BaseUrl).create(RetrofitService::class.java)

}