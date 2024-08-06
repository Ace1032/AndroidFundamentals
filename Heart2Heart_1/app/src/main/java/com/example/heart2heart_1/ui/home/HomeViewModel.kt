package com.example.heart2heart_1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heart2heart_1.sampledata.NewsArticles

class HomeViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<NewsArticles>>()
    val articles: LiveData<List<NewsArticles>> = _articles


     fun getArticles(){
        val articles = listOf(
            NewsArticles("Title 1", ""),
            NewsArticles("Title 2", ""),
            // Add more articles here
        )
        _articles.value = articles


    }


}