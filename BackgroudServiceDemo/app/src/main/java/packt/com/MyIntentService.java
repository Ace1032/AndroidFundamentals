package packt.com;

import android.app.IntentService;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;

import java.io.File;

import android.media.MediaPlayer;

public class MyIntentService extends IntentService {
    private static final String TAG=MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("MyBackgroundThread");
    }



    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate, Thread name "+ Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
/*        Log.i(TAG,"onHandleIntent, Thread name "+ Thread.currentThread().getName());

        int ctr=1;
        while(ctr<=12){
            Log.i(TAG,"Time elapsed "+ ctr+ "secs");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            ctr++;
        }
        */



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy, Thread name "+ Thread.currentThread().getName());
    }
}
