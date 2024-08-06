package com.example.heart2heart_1.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heart2heart_1.sampledata.ChatMessage

class NotificationsViewModel : ViewModel() {

    private val _messages = MutableLiveData<List<ChatMessage>>()
    val messages: LiveData<List<ChatMessage>> = _messages


    init{
        val messageList = listOf(
            ChatMessage("Sender 1", "Message 1", 1234567890),
            ChatMessage("Sender 2", "Message 2", 1234567891)
        )
        _messages.value = messageList


    }

}