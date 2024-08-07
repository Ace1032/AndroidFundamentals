package com.example.heart2heart_1.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.heart2heart_1.sampledata.DataRepository

class HomeViewModelFactory(private val repository: DataRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
       throw IllegalArgumentException("Unknown ViewModel class")
    }
}