package com.example.mvvmdemo.model

import com.example.mvvmdemo.R

class CityDataProvider  {

    private val cities= arrayListOf<City>()

    init{
        cities.add(City("Bangkok", R.drawable.bangkok, 200000))
        cities.add(City("Beijing", R.drawable.beijing, 200000))
        cities.add(City("Rio", R.drawable.rio, 200000))
        cities.add(City("London", R.drawable.london, 200000))
        cities.add(City("Rome", R.drawable.rome, 200000))
        cities.add(City("NewYork", R.drawable.newyork, 200000))
        cities.add(City("Paris", R.drawable.paris, 200000))
        cities.add(City("Singpore", R.drawable.singapore, 200000))
        cities.add(City("Sydney", R.drawable.sydney, 200000))
        cities.add(City("Tokyo", R.drawable.tokyo, 200000))
    }

    public fun getCities() :ArrayList<City>{
        return cities
    }
}