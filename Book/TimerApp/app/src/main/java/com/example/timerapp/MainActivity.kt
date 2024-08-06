package com.example.timerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.timerapp.databinding.ActivityMainBinding
import java.io.File
import java.util.Timer
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
        finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var text:EditText=findViewById(R.id.text_view_id_referance)
        File(filesDir,"dataFile.text").writeText(text.toString())
    }


}



