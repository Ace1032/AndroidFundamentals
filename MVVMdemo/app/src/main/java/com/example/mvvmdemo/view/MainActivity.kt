package com.example.mvvmdemo.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.viewmodel.CityViewModel



class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model: CityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        }

    override fun onResume() {
        super.onResume()
        model.getCityData().observe(this,{ city ->
            binding.imageId.setImageDrawable(
               ResourcesCompat.getDrawable(resources,city.img,applicationContext.theme)
            )
            binding.cityNameId.text=city.name
            binding.cityPopulationId.text=city.population.toString()
        })

    }

}