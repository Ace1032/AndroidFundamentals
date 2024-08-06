package com.example.practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.media3.common.util.Log
import com.example.practice2.DatabaseHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var homeFragment :HomeFragment= HomeFragment()
        var alartFragment:AlartFragment= AlartFragment()

        //val dbHelper = DatabaseHelper(this)
        //dbHelper.writableDatabase

        supportFragmentManager.beginTransaction().replace(
            R.id.container, homeFragment).commit()

        val bottomNavigationView:BottomNavigationView= findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.container,
                        homeFragment
                    ).commit()
                    true
                }

                R.id.alart -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.container,
                        alartFragment
                    ).commit()
                    true
                }

                else -> false
            }

        }



    }
}