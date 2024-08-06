package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var bottomNaviView: BottomNavigationView
    private lateinit var homeFragment: HomeFragment
    private lateinit var settingFragment: SettingFragment
    private lateinit var notifiFragment: NotificationFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNaviView= findViewById(R.id.bottom_navigation)
        homeFragment= HomeFragment()
        settingFragment= SettingFragment()
        notifiFragment= NotificationFragment()




        bottomNaviView.setOnItemSelectedListener {menuItem->
            when(menuItem.itemId){
                R.id.home ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,homeFragment).commit()
                    true
                }
                R.id.setting ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container,settingFragment).commit()
                    true
                }
                R.id.notification ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, notifiFragment).commit()
                    true
                }
                else ->false
            }

        }


    }
}

