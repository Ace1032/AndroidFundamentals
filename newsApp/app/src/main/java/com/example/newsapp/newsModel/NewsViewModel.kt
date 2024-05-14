package com.example.newsapp.newsModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private lateinit var _articles: List<Article>

    fun fetchNews(){
        viewModelScope.launch{
            //newsRepository.fetchNews()
        }
    }
}