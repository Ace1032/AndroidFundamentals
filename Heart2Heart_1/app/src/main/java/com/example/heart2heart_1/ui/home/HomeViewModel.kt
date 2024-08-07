package com.example.heart2heart_1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heart2heart_1.sampledata.DataRepository
import com.example.heart2heart_1.sampledata.NewsArticles

class HomeViewModel (private val repository: DataRepository): ViewModel() {

    val articles: LiveData<List<NewsArticles>> =repository.newsArticles

    fun addArticle() {
        repository.addArticles()
    }

    fun updateArticle(article: NewsArticles) {
        repository.UpdateNews(article)
    }


}