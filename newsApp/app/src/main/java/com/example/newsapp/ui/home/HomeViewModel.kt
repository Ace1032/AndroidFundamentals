package com.example.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.newsModel.Article
import com.example.newsapp.newsModel.NewsRepository

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private var _articles: LiveData<List<Article>> = newsRepository.articles




    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text





   // val articles: LiveData<List<Article>>
       // get() = _articles

}