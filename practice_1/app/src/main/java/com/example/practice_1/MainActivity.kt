package com.example.practice_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crimeFragment: Fragment = CrimeFragment()

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            crimeFragment
        ).commit()

        val bottomNavigationView: BottomNavigationView = findViewById(
            R.id.bottom_navigation
        )

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    val crimeFragment: Fragment = CrimeFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        crimeFragment
                    ).commit()
                    true
                }

                R.id.navigation_dashboard -> {
                    val crimeFragment: Fragment = CrimeFragment()
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        crimeFragment
                    ).commit()
                    true

                }

                else -> false
            }

        }
    }
}

