package com.example.heart2heart.data

import android.util.Log
import com.example.heart2heart.data.model.LoggedInUser
import kotlin.Result

class RegisterRepositor(val dataSource: RegisterDataSource) {

    suspend fun registerUser(firstName: String, lastName: String, email: String, password: String, dob: String):Result<Boolean>{
        Log.d("RegisterRepositor", "Registering user with email: $email")
        val result = dataSource.registerUser(firstName, lastName, email, password, dob)

        return result
    }

}