package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            var crimedetailFragment:CrimeDetailFragment  = CrimeDetailFragment()

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                crimedetailFragment).commit()





    }
}