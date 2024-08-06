package com.example.mymusicapp.view

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.mymusicapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import com.example.mymusicapp.Manifest

class MusicService :Service(),CoroutineScope{

    private lateinit var job:Job
    private var mediaPlayer: MediaPlayer?= null
    private val binder = MusicBinder()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate() {
        super.onCreate()
        job = Job()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return  binder
    }



    fun playMusic(){
        launch {
            withContext(Dispatchers.IO){
                mediaPlayer= MediaPlayer.create(applicationContext, R.raw.love)
                mediaPlayer?.isLooping = true
                mediaPlayer?.start()
            }
        }
    }

    fun stopMusic(){
        launch{
            withContext(Dispatchers.IO){
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer=null
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        mediaPlayer?.release()
        mediaPlayer=null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    inner class MusicBinder:Binder() {
        fun getService() : MusicService =this@MusicService
    }

    companion object {
        const val NOTICATION_ID =1
        const val CHANEL_ID = "MusicServiceChanel"
    }


}