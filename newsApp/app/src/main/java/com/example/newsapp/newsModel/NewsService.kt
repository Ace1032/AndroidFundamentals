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

    private lateinit var articles: List<Article>

    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val newsApi = retrofit.create(NewsApi::class.java)

    suspend fun fetchNews(): List<Article>? {
        Log.d("trace fail","NewsService -> fetchNews()")
            return withContext(Dispatchers.IO) {

            try {
                val response = newsApi.getTopHeadlines(API_KEY, "war")
                Log.e("Error response", response.isSuccessful.toString())
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    Log.d("this is respond message", "Parsed Response: $apiResponse")
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
            return articles
    }

}

interface NewsApi {
    @GET("news")
    suspend fun getTopHeadlines(
        @Query("apikey") apiKey: String,
        @Query("q") query: String
    ): Response<ApiResponse>
}

