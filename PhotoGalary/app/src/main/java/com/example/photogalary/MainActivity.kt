package com.example.photogalary

import android.net.http.HttpException
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresExtension
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class MainActivity : AppCompatActivity() {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
                val response = RetrofitInstance.api.fetchData()
                Log.d("ActivityMain ", "hello")
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (!responseBody.isNullOrEmpty()) {
                       // val data = Gson().fromJson(responseBody, Array<Frame>::class.java).toList()
                        withContext(Dispatchers.Main) {
                            // Update UI with data
                            //updateUI(data)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            // Handle empty data
                            showError("No data available")
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        // Handle error
                        showError("Failed to fetch data")
                    }
                }


        }
    }

    private fun updateUI(data: List<Frame>) {
        // Update your UI here
    }

    private fun showError(message: String) {
        // Show error message
    }
}