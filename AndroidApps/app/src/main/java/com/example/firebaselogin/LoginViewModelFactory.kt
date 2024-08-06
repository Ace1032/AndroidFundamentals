package com.example.firebaselogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginViewModelFactory(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore
): ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(auth, db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}