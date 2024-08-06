package com.example.mymusicapp_test_1

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private lateinit var play_button: Button
    private var isPlaying: Boolean = false
    private lateinit var musicPlayer: MusicPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play_button= findViewById(R.id.btnPlay)
        musicPlayer = MusicPlayer(this)


        play_button.setOnClickListener{
            if (!isPlaying) {
                musicPlayer.playMusic("MyMusicApp_test_1/app/src/main/res/raw/blows.mp3")
                play_button.text = "Pause"
                isPlaying = true
            } else {
                musicPlayer.stopMusic()
                play_button.text = "Play"
                isPlaying = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        musicPlayer.stopMusic()
    }


}