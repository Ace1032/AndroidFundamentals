package com.example.heart2heart.ui.notifications

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.heart2heart.data.RegisterRepositor
import kotlinx.coroutines.launch


class RegisterViewModel(private val registerRepository: RegisterRepositor) : ViewModel() {
    private val _registerResult = MutableLiveData<RegisterState>()
    val registerResult: LiveData<RegisterState> = _registerResult

    fun registerUser(
        firstName: String,
        lastName: String,
        dob: String,
        email: String,
        password: String
        ){
        if (isValidEmail(email) && isValidPassword(password) && isValidName(firstName, lastName) && dob.isNotEmpty()) {

            viewModelScope.launch{
                Log.d("RegisterViewModel", "Valid input")
                registerRepository.registerUser(firstName, lastName, email, password, dob)

            }
        }else{
            val isValiedEmail = isValidEmail(email)
            val isValidPassword = isValidPassword(password)
            if( !isValidEmail(email)) _registerResult.value = RegisterState(emailError = -1)
            if( !isValidPassword(password)) _registerResult.value = RegisterState(passwordError = -1)
            if(!isValidName(firstName, lastName)) _registerResult.value = RegisterState(nameError = -1)

            Log.d("RegisterViewModel", "Invalid input")
            Log.d("RegisterViewModel", "name ${firstName.toString()} ${lastName.toString()}")
            Log.d("RegisterViewModel", " password $password $isValidPassword")
            Log.d("RegisterViewModel", "email  $email $isValiedEmail")

        }


    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }
    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=.])(?=\\S+\$).{7,}\$"
        return password.matches(passwordPattern.toRegex())
    }
    fun isValidName(firstName: String, lastName: String): Boolean {
        return firstName.isNotEmpty() && lastName.isNotEmpty()
    }








}