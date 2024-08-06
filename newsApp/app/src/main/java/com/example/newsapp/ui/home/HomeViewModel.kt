package com.example.newsapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.newsModel.Article
import com.example.newsapp.newsModel.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {





    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }


    var articles=  newsRepository.getArticles()

    private val _articles = MutableLiveData<List<Article>>().apply {
        value=articles
    }
    val live_articles:LiveData<List<Article>> = _articles

    val text: LiveData<String> = _text


    fun fetchNews(){
        viewModelScope.launch{
            try {
                newsRepository.fetchNews()
            }catch (e:Exception){
                Log.e("Error", e.toString())
            }
        }
    }



   // val articles: LiveData<List<Article>>
       // get() = _articles

}