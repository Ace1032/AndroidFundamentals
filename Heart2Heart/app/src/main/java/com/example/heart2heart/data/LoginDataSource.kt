package com.example.heart2heart.data

import android.util.Log
import com.example.heart2heart.data.model.LoggedInUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.IOException


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {
    val db = Firebase.firestore
    val auth = FirebaseAuth.getInstance()

     suspend fun login(username: String, password: String): Result<LoggedInUser<Any>> {
         return try {
             // Switch to IO context for network operations
             withContext(Dispatchers.IO) {
                 helpLogin(username, password)
             }
         } catch (e: Throwable) {
             Result.Error(IOException("Error logging in", e))
         }
    }

    suspend fun helpLogin(username: String, password: String): Result<LoggedInUser<Any>> {
        return try {
            val authResult = auth.signInWithEmailAndPassword(username, password).await()
            val userId = authResult.user?.uid
            if (userId != null) {
                val fakeUser = LoggedInUser<Any>(userId, username)
                //Log.d("LoginDataSource", "User logged in with UID: $userId")
                Result.Success(fakeUser)
            } else {
                Result.Error(IOException("Error logging in"))
            }
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
        }

    fun logout() {
        // TODO: revoke authentication
    }
}