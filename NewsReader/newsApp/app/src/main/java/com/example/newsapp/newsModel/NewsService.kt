package com.example.newsapp.newsModel

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object  NewsService {
    private const val BASE_URL = "https://newsdata.io/api/1/"
    private const val API_KEY = "pub_43543540bc94b792a64e0aa9feec878441a4d"

    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val newsApi = retrofit.create(NewsApi::class.java)

    suspend fun fetchNews(): List<Article>? {
        return withContext(Dispatchers.IO) {

            try {
                val response = newsApi.getTopHeadlines(API_KEY, "war")
                Log.e("Error response", response.toString())
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    apiResponse?.results
                } else {
                    Log.e("Error", "fetchNews() from NewsService")
                    null
                }
            } catch (e: Exception) {
                Log.e("Error", e.toString())
                null
            }

        }

    }

}

interface NewsApi {
    @GET("news")
    suspend fun getTopHeadlines(
        @Query("apikey") apiKey: String,
        @Query("q") query: String
    ): Response<ApiResponse>
}

