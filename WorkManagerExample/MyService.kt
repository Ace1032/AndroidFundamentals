package com.example.servicespractice_1

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyService : Service() {
    private val binder = LocalBinder()
    private val serviceScope= CoroutineScope(Dispatchers.IO + Job())

    inner class LocalBinder : Binder(){
        fun getService(): MyService = this@MyService
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

     suspend fun getRandomNum():Int{
        return serviceScope.async {
          getTaskResult()
        }.await()

    }

    private suspend fun getTaskResult(): Int {
        delay(3000)
        return (1..100).random()
    }
}