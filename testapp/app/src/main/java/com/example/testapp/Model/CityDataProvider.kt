package com.example.testapp.Model

import com.example.testapp.R

class CityDataProvider {
    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Bangkok", R.drawable.bangkok))
        cities.add(City("London", R.drawable.london))
        cities.add(City("Beijing", R.drawable.beijing))
        cities.add(City("Rio", R.drawable.rio))

    }


    fun getCities(): ArrayList<City> {
        return cities
    }
}