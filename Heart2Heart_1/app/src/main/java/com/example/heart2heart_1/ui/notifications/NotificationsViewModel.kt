package com.example.heart2heart_1.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heart2heart_1.sampledata.ChatMessage
import com.example.heart2heart_1.sampledata.DataRepository

class NotificationsViewModel (private val repository: DataRepository): ViewModel() {


    val messages: LiveData<List<ChatMessage>> =repository.messages


    fun addMessages(){
        repository.addMessages()

    }
    fun updateMessages(message: ChatMessage){
        repository.updateMessages(message)
    }

}