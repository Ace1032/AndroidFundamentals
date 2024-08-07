package com.example.heart2heart_1.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heart2heart_1.sampledata.ActivityItem
import com.example.heart2heart_1.sampledata.DataRepository

class DashboardViewModel(private val repository: DataRepository) : ViewModel() {

   // private var _myActivities = MutableLiveData<List<ActivityItem>>()
    val myActivities: LiveData<List<ActivityItem>> =repository.activityItemsMy
  //  private val _upcomingActivities = MutableLiveData<List<ActivityItem>>()
    val upcomingActivities: LiveData<List<ActivityItem>> = repository.activityItemsUpComing


    fun addMyActivities(){
        repository.addMyActivitys()
    }
    fun updateMyActivities(myActivity: ActivityItem){}
    fun addUpcomingActivities(){
        repository.addUpComingActivitys()
    }
    fun updateUpcomingActivities(upcomingActivity: ActivityItem){}






}