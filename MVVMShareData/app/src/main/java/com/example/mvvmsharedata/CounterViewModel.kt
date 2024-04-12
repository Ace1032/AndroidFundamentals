package com.example.mvvmsharedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private var count= MutableLiveData<Int>()

    init{
        count.value=0
    }

    fun incrementCount(){
        count.value= count.value!! +1
    }
    fun decrementCount(){
        count.value= count.value!! -1
    }
    fun getCount():LiveData<Int>{
        return count
    }
}