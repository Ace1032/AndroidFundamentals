package com.example.firebaselogin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginViewModel(private val auth: FirebaseAuth, private val db: FirebaseFirestore) : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> get()= _loginResult
    private val _userData = MutableLiveData<String>()
    val userData: LiveData<String> get() = _userData


    fun authenticateUser(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{task ->
                if (task.isSuccessful){
                    val userId = task.result?.user?.uid
                    _loginResult.value = true
                    if (userId != null) {
                        _userData.value = userId
                        Log.d("LoginViewModel", "User logged in with UID: $userId")
                        fetchUserData(userId)
                    }
                } else {
                    _loginResult.value = false
                }
            }
            .addOnFailureListener{
                _loginResult.value=false
            }
    }

    private fun fetchUserData(documentId: String) {
            db.collection("users").document(documentId)
                .get()
                .addOnSuccessListener { document ->
                    if(document !=null && document.exists()){
                      val documentData= document.data
                        Log.d("LoginViewModel", "Document data: $documentData")
                }else{
                    Log.d("LoginViewModel", "No such a document")
                }

                }
    }



    fun registerUser(user : HashMap<String, String>){
        val first = user["first"]
        val last = user["last"]
        val email = user["email"]
        val pass = user["pass"]
        Log.d("LoginViewModel", "Successfully in the function registerUser()")

        if (email != null && pass != null) {
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val userId = task.result?.user?.uid
                        Log.d("LoginViewModel", "User created with UID: $userId")

                        if (userId != null) {
                            createUserDocument(userId, first, last)
                        } else {
                            Log.d("LoginViewModel", "userId is null after successful authentication")
                        }
                    } else {
                        Log.w("LoginViewModel", "Authentication failed: ${task.exception?.message}")
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("LoginViewModel", "Error during authentication: ", e)
                }
        } else {
            Log.d("LoginViewModel", "Email or password is null")
        }
        }

    private fun createUserDocument(userId: String, first: String?, last: String?) {
        val db = FirebaseFirestore.getInstance()
        val userDocRef = db.collection("users").document(userId)

        val userData = hashMapOf(
            "first" to first,
            "last" to last
        )
        Log.d("LoginViewModel", " successfully in the function createUserDocument() ")
        userDocRef.set(userData)
            .addOnSuccessListener {
                Log.d("LoginViewModel", "User document created successfully")
            }
            .addOnFailureListener{
                Log.d("LoginViewModel", "Failed to create user document")
            }

    }


}