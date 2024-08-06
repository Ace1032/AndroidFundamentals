package com.example.mymusicapp_test_1

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import java.io.IOException

class MusicPlayer : Service(),AudioManager.OnAudioFocusChangeListener  {


    private val binder: IBinder = MusicBinder()
    private var mediaPlayer : MediaPlayer?=null
    private var audioFocusRequest: AudioFocusRequest? =null
    private lateinit var audioManager: AudioManager


    inner class MusicBinder : Binder(){
        fun getSevice(): MusicPlayer =this@MusicPlayer
    }


    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onCreate() {
        super.onCreate()
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        createMediaPlayer()
    }

    private fun createMediaPlayer() {
        mediaPlayer= MediaPlayer()
        mediaPlayer?.setOnCompletionListener {
            stopSelf()
        }
    }

    fun playMusic(path: String) {
        mediaPlayer?.apply {
            release()
        }

        mediaPlayer = MediaPlayer()

        try {
            mediaPlayer?.apply {
                setDataSource(applicationContext, Uri.parse(path))
                prepare()
                start()
            }

            requestAudioFocus()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun requestAudioFocus() {
        if (audioFocusRequest == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                audioFocusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setOnAudioFocusChangeListener(this)
                    .build()
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioManager.requestAudioFocus(audioFocusRequest!!)
        }
    }

    fun stopMusic() {
        mediaPlayer?.apply {
            stop()
            release()
        }
        stopForeground(true)
        abandonAudioFocus()
    }

    private fun abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioManager.abandonAudioFocusRequest(audioFocusRequest!!)
        }
    }

    override fun onAudioFocusChange(focusChange: Int) {
        when (focusChange) {
            AudioManager.AUDIOFOCUS_GAIN -> {
                mediaPlayer?.apply {
                    if (!isPlaying) {
                        start()
                    }
                }
            }
            AudioManager.AUDIOFOCUS_LOSS -> {
                mediaPlayer?.apply {
                    if (isPlaying) {
                        stop()
                    }
                }
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                mediaPlayer?.apply {
                    if (isPlaying) {
                        pause()
                    }
                }
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> {
                mediaPlayer?.apply {
                    setVolume(0.2f, 0.2f)
                }
            }
        }
    }

    private fun createNotification(): Notification {
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("music_playback", "Music Playback")
            } else {
                ""
            }

        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("Music Player")
            .setContentText("Playing music")
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String {
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_LOW)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        return channelId
    }

    companion object {
        private const val NOTIFICATION_ID = 101
    }




}


