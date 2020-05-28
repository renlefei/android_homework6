package com.example.dihomework.apiService

import com.example.dihomework.model.Advice
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("advice")
    fun getAdvice(): Call<Advice>
}