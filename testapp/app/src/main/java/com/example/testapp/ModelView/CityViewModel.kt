package com.example.testapp.ModelView

import android.os.Looper.getMainLooper
import android.os.Looper.loop
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapp.Model.City
import com.example.testapp.Model.CityDataProvider

class CityViewModel: ViewModel() {

    private val citydata=MutableLiveData<City>()
    private val cities= CityDataProvider().getCities()
    private var currentIndex=0
    private var delay=2000L

    init {
        loop()
    }

    private fun loop(){
       android.os.Handler(getMainLooper()).postDelayed({UpdateCity()},delay)
    }

    fun getcityData():LiveData<City>{
        return citydata
    }

   fun UpdateCity() {
       currentIndex++
       currentIndex= currentIndex % cities.size
       citydata.value=cities[currentIndex]
    }

}


