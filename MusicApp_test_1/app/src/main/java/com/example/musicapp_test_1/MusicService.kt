package com.example.musicapp_test_1

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

class MusicService: Service() {

    private lateinit var mediaPlayer: MediaPlayer
    private val  binder= MusicBinder()
    private val NOTIFICATION_ID = 1

    inner class MusicBinder: Binder() {
        fun getService() : MusicService = this@MusicService
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }


    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.sayitoldyou)
        mediaPlayer.isLooping = true

        // Log track name
        val trackName = resources.getResourceEntryName(R.raw.sayitoldyou)
        Log.d("MusicService", "Track Name: $trackName")


        mediaPlayer.setOnPreparedListener {
        Log.d("MusicService", "MediaPlayer is prepared.")
    }

        val notification = createNotification()
        startForeground(NOTIFICATION_ID, notification)
    }


    private fun createNotification(): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        return NotificationCompat.Builder(this, "MusicChannel")
            .setContentTitle("Music Service")
            .setContentText("Playing Music")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .build()
    }

    fun playmusic(){
        if(!mediaPlayer.isPlaying){
            Log.d("MusicService", "music Play")
            mediaPlayer.start()

        }
    }

    fun stopMusic(){
        if(mediaPlayer.isPlaying){
            mediaPlayer.stop()
            Log.d("MusicService", "music stop")
        }
    }

    fun pauseMusic(){
        if(mediaPlayer.isPlaying){
            mediaPlayer.pause()
            Log.d("MusicService", "music Pause")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()

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

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!hasForegroundServicePermission()) {
            requestForegroundServicePermission()
            return START_NOT_STICKY
        }
        return super.onStartCommand(intent, flags, startId)
    }



}