package com.example.android.retrofitinrecycleview.Retrofit

import retrofit2.Call
import com.example.android.retrofitinrecycleview.Model.User
import retrofit2.http.GET

interface RetrofitService {
    @GET("users")
    fun getUser():Call<MutableList<User>>
}