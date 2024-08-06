package com.example.musicapp_test_2

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MusicService  : Service(){

    private val channel_ID = "ForgoundServiceChanel"


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input= intent?.getStringArrayExtra("inputExtra")

        var notification : Notification = (
            NotificationCompat.Builder(this, channel_ID)
                .setContentTitle("Foreground service example")
                .setContentText(input.toString()).setSmallIcon(R.drawable.ic_launcher_foreground)
                .build()
        )

        startForeground(1,notification)


        Thread {
            for(i in 0 until 5){
                try {
                    Thread.sleep(1000L)
                } catch (e: InterruptedException){
                    e.printStackTrace()
                }
            }
        }

        return START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }



    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel= NotificationChannel(
                channel_ID,
                "Foregound Service Channnel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val mananger= getSystemService(NotificationManager::class.java)
            mananger.createNotificationChannel(serviceChannel)
        }
    }
}