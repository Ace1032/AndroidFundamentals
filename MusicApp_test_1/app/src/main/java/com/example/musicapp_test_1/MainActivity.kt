package com.example.musicapp_test_1

import android.app.Service
import android.app.Service.START_NOT_STICKY
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

   private var musicService : MusicService? = null
    private var isBound = false


    private var connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var binder = service as MusicService.MusicBinder
            musicService = binder.getService()
            isBound= true
            Log.d("MainActivity", "Service is bound.")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound= false
            Log.d("MainActivity", "Service is unbound.")
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val playButton: Button = findViewById(R.id.play_Button)
        val pauseButton: Button = findViewById(R.id.pause_Button)
        val stopPlay: Button= findViewById(R.id.stop_Button)

        playButton.setOnClickListener{
            musicService?.playmusic()
        }

        pauseButton.setOnClickListener{
            musicService?.pauseMusic()
        }

        stopPlay.setOnClickListener{
            musicService?.stopMusic()
        }

    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MusicService::class.java)
        bindService(intent, connection,Context.BIND_AUTO_CREATE )
    }

    override fun onStop() {
        super.onStop()
        if(isBound){
            unbindService(connection)
            isBound= false
        }

    }

    private fun hasForegroundServicePermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.FOREGROUND_SERVICE
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestForegroundServicePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            requestPermissions(arrayOf(android.Manifest.permission.FOREGROUND_SERVICE), 1)
        }
    }





}