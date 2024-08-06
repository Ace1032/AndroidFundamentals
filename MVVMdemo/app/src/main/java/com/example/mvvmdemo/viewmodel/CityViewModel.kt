package com.example.mvvmdemo.viewmodel

import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.model.City
import com.example.mvvmdemo.model.CityDataProvider

class CityViewModel:ViewModel() {

    private val cityData= MutableLiveData<City>()
    private val cities=CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay= 2000L

    init{
        loop()
    }

   fun getCityData():LiveData<City>{
       return cityData
   }
    private fun loop() {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            updateCity()},
            delay)
    }

    private fun updateCity() {
        currentIndex++
        currentIndex=currentIndex% cities.size
        cityData.value=cities[currentIndex]
        loop()
    }


}