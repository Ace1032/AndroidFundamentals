package com.example.photogalary

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {

    @GET("endpoint")
    suspend fun fetchData(): Response<List<Frame>>


}