package com.example.servicespractice_1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private var myService :MyService? =null
    private var isBind: Boolean = false
    private  var text : TextView? =null


    private val connect = object: ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var binder = service as MyService.LocalBinder
            myService = binder.getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBind = false
            myService=null
        }


    }

    override fun onStart() {
        super.onStart()
        Intent(this,MyService::class.java ).also { intent ->
            bindService(intent, connect, Context.BIND_AUTO_CREATE)
            isBind=true
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val WorkRequest = OneTimeWorkRequestBuilder<RandomNumberWorker>().build()

        // Enqueue the periodic work request
        WorkManager.getInstance(this).enqueue(WorkRequest)

        // Observe the work result (optional)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(WorkRequest.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null && workInfo.state == WorkInfo.State.SUCCEEDED) {
                    // Get the output data
                    val randomNumber = workInfo.outputData.getString("random_number")
                    // Use the random number
                    Log.d("MainActivity" ," state is $randomNumber")
                }
            })






        var start: Button = findViewById(R.id.start_button)
        text  = findViewById(R.id.text)


        Log.d("MainActivity", "$isBind")
        start.setOnClickListener{
            Log.d("MainActivity", "$isBind")
            if(isBind){
                    text?.text = getRandomNumberFromMyService().toString()
            }
        }

    }

    private  fun getRandomNumberFromMyService(){

        GlobalScope.launch(Dispatchers.Main){
            Log.d("MainActivity", "${myService?.getRandomNum()}")
            text?.text = myService?.getRandomNum().toString() ?:"0"
        }

    }


}