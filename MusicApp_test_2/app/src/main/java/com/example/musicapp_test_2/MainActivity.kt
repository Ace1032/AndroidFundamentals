package com.example.musicapp_test_2

import android.app.ActivityManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var statusTextView:TextView

    private val broadcastReceiver= object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            checkServiceStatus()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button= findViewById(R.id.startButton)
        statusTextView= findViewById(R.id.statusTextView)

        startButton.setOnClickListener{
            startForeGroundService()
        }
        checkServiceStatus()
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(broadcastReceiver, IntentFilter("foregroundServiceStopped"))
    }


    override fun onPause() {
        super.onPause()
        unregisterReceiver(broadcastReceiver)
    }



    private fun startForeGroundService() {
       val musicServiceIntent= Intent(this, MusicService::class.java)
        musicServiceIntent.putExtra("inputExtra", "Foreground service example in Android!")

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Log.d("MainActivity", "calling startForegroundService(musicServiceIntent)")
            startForegroundService(musicServiceIntent)
        }else{
            Log.d("MainActivity", "startService(musicServiceIntent)")
            startService(musicServiceIntent)
        }
    }


    private fun checkServiceStatus() {
        var manager= getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        var runningServices= manager.getRunningServices(Integer.MAX_VALUE)

        var isServiceRunning = false

        for(service in runningServices){
            if(MainActivity::class.java.name == service.service.className ){
                isServiceRunning = true
                break
            }
        }

        if(isServiceRunning){
            statusTextView.text=  "Foreground Service is Running"
        } else{
            statusTextView.text=  "Foreground Service is Not Running"
        }



    }



}