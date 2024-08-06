package com.example.heart2heart.ui.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.heart2heart.data.LoginDataSource
import com.example.heart2heart.data.LoginRepository
import com.example.heart2heart.data.RegisterDataSource
import com.example.heart2heart.data.RegisterRepositor
import com.example.heart2heart.ui.login.LoginViewModel

class RegisterViewModelFactory : ViewModelProvider.Factory {



        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
                return RegisterViewModel(
                    registerRepository = RegisterRepositor(
                        dataSource = RegisterDataSource()
                    )
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }



}