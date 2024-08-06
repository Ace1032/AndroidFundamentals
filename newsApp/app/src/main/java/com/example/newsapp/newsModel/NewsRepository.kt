package com.example.newsapp.newsModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewsRepository {
    private lateinit var articles:List<Article>

    suspend fun fetchNews() {
        Log.d("trace fail", "NewsRepository -> fetchNews()")
        val fetchedArticles = NewsService.fetchNews()

        if (fetchedArticles != null) {
            Log.d("result article", "Fetched Articles Size: ${fetchedArticles.size}")
            articles=fetchedArticles
            Log.d("result article", "Fetched Articles Size: ${fetchedArticles.size}")
        } else {
            Log.e("Error from newsRepository", "fetchNews() from NewsRepository: fetchedArticles is null")
        }
    }

    fun getArticles(): List<Article>{
        return articles
    }

}


