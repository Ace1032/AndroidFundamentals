package com.example.heart2heart_1.sampledata

import android.icu.text.CaseMap.Upper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataRepository {
    private val _newsArticles = MutableLiveData<List<NewsArticles>>()
    val newsArticles: LiveData<List<NewsArticles>>get() = _newsArticles

    private val _activityItemsUpComing = MutableLiveData<List<ActivityItem>>()
    val activityItemsUpComing: LiveData<List<ActivityItem>> = _activityItemsUpComing

    private val _activityItemsMy = MutableLiveData<List<ActivityItem>>()
    val activityItemsMy: LiveData<List<ActivityItem>> = _activityItemsMy

    private val _messages = MutableLiveData<List<ChatMessage>>()
    val messages: LiveData<List<ChatMessage>> = _messages

    init {
        _newsArticles.value = mutableListOf()
        _activityItemsUpComing.value = mutableListOf()
        _activityItemsMy.value = mutableListOf()
        _messages.value = mutableListOf()
    }

    fun addMessages(){
        val updatedMessageList = listOf(
            ChatMessage("Sender 1", "Message 1", 1234567890),
            ChatMessage("Sender 2", "Message 2", 1234567891)
        )
        _messages.value = updatedMessageList
    }
    fun updateMessages(message: ChatMessage){
        val updatedMessageList = _messages.value?.toMutableList()
        updatedMessageList?.add(message)
        _messages.value = updatedMessageList
    }

    fun addUpComingActivitys() {
        val upComingActivityList = listOf(
            ActivityItem("Activity 3", "Date 1", ""),
            ActivityItem("Activity 4", "Date 2", "")
        )
        _activityItemsUpComing.value = upComingActivityList
    }
    fun updateUpComingActivitys(activity: ActivityItem){
        val updatedActivityList = _activityItemsUpComing.value?.toMutableList()
        updatedActivityList?.add(activity)
        _activityItemsUpComing.value = updatedActivityList
    }

    fun addMyActivitys() {
        val myActivityList = listOf(
            ActivityItem("Activity 5", "Date 1", ""),
            ActivityItem("Activity 6", "Date 2", "")
        )
        _activityItemsMy.value = myActivityList
    }

    fun addUpComingActivitys(activity: ActivityItem){
        val updatedActivityList = _activityItemsUpComing.value?.toMutableList()
        updatedActivityList?.add(activity)
        _activityItemsUpComing.value = updatedActivityList
    }

    fun addArticles() {
        val sampleArticles = listOf(
            NewsArticles("Article 1", "https://example.com/image1.jpg"),
            NewsArticles("Article 2", "https://example.com/image2.jpg")

        )
        _newsArticles.value = sampleArticles

    }
    fun UpdateNews(article: NewsArticles){
        val updatedNews = _newsArticles.value?.toMutableList()
        updatedNews?.add(article)
        _newsArticles.value = updatedNews
    }






}