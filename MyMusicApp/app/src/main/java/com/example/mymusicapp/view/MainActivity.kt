package com.example.mymusicapp.view

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.app.Service
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.mymusicapp.Manifest

import com.example.mymusicapp.R
import com.example.mymusicapp.databinding.ActivityMainBinding
import com.example.mymusicapp.viewmodel.SpotifyClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import android.app.Notification
import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var musicService: MusicService?=null
    private var isBound = false


        private val connection = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                val binder = service as MusicService.MusicBinder
                musicService = binder.getService()
                isBound = true
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                isBound = false
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MusicService::class.java)
        bindService(intent,connection, Context.BIND_AUTO_CREATE )

        binding.playButton.setOnClickListener{
            musicService?.playMusic()
        }
        binding.stopButton.setOnClickListener{
            musicService?.stopMusic()
        }
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                MusicService.CHANEL_ID,
                "Music Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val notificationManager= getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

    }

    private fun startForegroundService(){
        val notificationIntent= Intent(this, MainActivity::class.java)
        val pendingintent= PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            0
        )
        val notification= NotificationCompat.Builder(this, MusicService.CHANEL_ID)
            .setContentTitle("Music Service")
            .setContentText("Playing Music")
            .setSmallIcon(R.drawable.xeneeze)
            .setContentIntent(pendingintent)
            .build()
        //startForground(MusicService.NOTICATION_ID, notification)
    }


    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
        isBound = false
        }



}