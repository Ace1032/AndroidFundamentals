package com.example.heart2heart_1.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heart2heart_1.sampledata.ActivityItem

class DashboardViewModel : ViewModel() {

    private var _myActivities = MutableLiveData<List<ActivityItem>>()
    val myActivities: LiveData<List<ActivityItem>> = _myActivities
    private val _upcomingActivities = MutableLiveData<List<ActivityItem>>()
    val upcomingActivities: LiveData<List<ActivityItem>> = _upcomingActivities


    init {
    val myActivityList = listOf(
        ActivityItem("Activity 1", "Date 1", ""),
        ActivityItem("Activity 2", "Date 2", "")
    )
        val upComingActivityList = listOf(
            ActivityItem("Activity 3", "Date 1", ""),
            ActivityItem("Activity 4", "Date 2", "")
        )

        _myActivities.value = myActivityList
        _upcomingActivities.value = upComingActivityList

    }




}