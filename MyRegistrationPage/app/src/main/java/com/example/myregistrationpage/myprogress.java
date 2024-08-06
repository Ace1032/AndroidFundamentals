package com.example.myregistrationpage;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.ProgressBar;

public class myprogress extends IntentService {
    private static final String TAG=myprogress.class.getSimpleName();

    public myprogress(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i=0;i<10;i++){
            Log.i(TAG,"COUNT :"+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
