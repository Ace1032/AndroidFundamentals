package com.example.heart2heart.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.heart2heart.ui.notifications.RegisterState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.IOException
import kotlin.Result

class RegisterDataSource {
    val db = Firebase.firestore
    val auth = FirebaseAuth.getInstance()
    private val _registerState = MutableLiveData<RegisterState>()
    val registerState: MutableLiveData<RegisterState> = _registerState


    suspend fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        dateOfBirth: String
    ): Result<Boolean> {
        return try {
            withContext(Dispatchers.IO) {
                val result = helpRegister(firstName, lastName, email, password, dateOfBirth)
                if (result) {
                    registerState.value?.result=true
                }
                Result.success(result)


            }
        } catch (e: Throwable) {
            registerState.value?.failReson = e.localizedMessage
            Result.failure(IOException("Error registering user", e))

        }
    }

    private suspend fun helpRegister(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        dateOfBirth: String
    ) :Boolean{
        try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val userId = authResult.user?.uid
            if (userId != null) {
                val user = hashMapOf(
                    "firstName" to firstName,
                    "lastName" to lastName,
                    "email" to email,
                    "dateOfBirth" to dateOfBirth
                )
                db.collection("users").document(userId).set(user).await()
                Log.d("RegisterDataSource", "User registered with UID: $userId")
                _registerState.value?.result=true
                return true
            } else {
                throw IOException("User ID is null")
            }
        } catch (e: Throwable) {
            Log.e("RegisterDataSource", "Error in helpRegister: ${e.localizedMessage}", e)
            _registerState.value?.failReson = e.localizedMessage
            throw e
        }
        return false
    }
}