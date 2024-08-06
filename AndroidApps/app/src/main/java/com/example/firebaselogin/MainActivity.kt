package com.example.firebaselogin

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firebaselogin.Home.HomeFragment
import com.example.firebaselogin.ui.theme.FirebaseLoginTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.firebaselogin.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    val db = Firebase.firestore
    val auth = FirebaseAuth.getInstance()
    lateinit var userId: String

    private  lateinit var binding: ActivityMainBinding

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val llayout: LinearLayout = findViewById(R.id.register_details)


        llayout.visibility = View.INVISIBLE


        val factory = LoginViewModelFactory(auth, db)
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        loginViewModel.loginResult.observe(this, Observer{ success ->
            if(success){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        })

        loginViewModel.userData.observe(this, Observer { userData ->
            if(userData != null){
                userId = userData
                navigateToHomeFragment()
                Log.d("MainActivity", "User data: $userId")
            }
        })


       binding.login.setOnClickListener {
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()
           // val documentId = "Cj4A6RZwrUNBxPYencyH"
            loginViewModel.authenticateUser(email, password)
        }

       binding.register.setOnClickListener{
            llayout.visibility = View.VISIBLE
        }
        binding.submit.setOnClickListener {
            val fName = binding.fName.text.toString()
            val lName = binding.lName.text.toString()
            val email = binding.email.text.toString()
            val pass = binding.newPass.text.toString()
            val user = hashMapOf(
                "first" to fName,
                "last" to lName,
                "email" to email,
                "pass" to pass)

            Log.d("MainActivity", "submit button clicked")
            loginViewModel.registerUser(user)

        }



    }

    private fun navigateToHomeFragment() {
        if(userId !=null && findViewById<FrameLayout>(R.id.fragment_container) != null){
            val homeFragment = HomeFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit()
        }
    }


}
