package com.example.newsapp.newsModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NewsRepository {
    private val _articles = MutableLiveData<List<Article>>()

    // Expose articles as LiveData to prevent external modification
    val articles: LiveData<List<Article>>
        get() = _articles

    suspend fun fetchNews() {
        suspend fun fetchNews() {
            val fetchedArticles = NewsService.fetchNews()
            fetchedArticles?.let { articles ->
                _articles.postValue(articles)
            } ?: run {
                Log.e("Error", "fetchNews() from NewsRepository: fetchedArticles is null")
            }
        }
    }
}