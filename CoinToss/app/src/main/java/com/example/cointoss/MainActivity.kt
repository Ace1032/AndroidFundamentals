package com.example.cointoss


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.cointoss.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

private lateinit var binding:ActivityMainBinding
private lateinit var toass_Button:Button
private lateinit var myIntent:Intent
private var toss:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toass_Button=binding.tossButtonId
        toass_Button.setOnClickListener {
            toss=randomizeResult()

            myIntent= Intent(this, MainActivity_result::class.java)
            myIntent.putExtra("toss",toss)
            startActivity(myIntent)
        }
    }

    private fun randomizeResult():Boolean{
        if(Random().nextInt(100)%2==0)  return true;
        else return false
    }
}