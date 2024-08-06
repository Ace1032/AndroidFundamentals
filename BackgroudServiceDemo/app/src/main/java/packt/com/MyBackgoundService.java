package packt.com;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyBackgoundService extends Service {
    private static final String TAG=MyBackgoundService.class.getCanonicalName();

    private int duration;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate, Thread name= "+Thread.currentThread().getName());
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand, Thread name= "+Thread.currentThread().getName());

        duration=intent.getIntExtra("sleepTime", 0);

        new MyAsyncTask().execute();//Back ground Thread

        //perform long dummy task
       /* try {
            Thread.sleep(12000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        */

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind, Thread name= "+Thread.currentThread().getName());
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy, Thread name= "+Thread.currentThread().getName());
        super.onDestroy();
    }

    class MyAsyncTask extends AsyncTask<Void,String,Void>{

        @Override
        protected void onPreExecute() {
            Log.i(TAG,"onPreExcute, Thread name "+ Thread.currentThread().getName());
            super.onPreExecute();
        }

        @Override//perform tasks in Background or Thread
        protected Void doInBackground(Void... voids) {
            Log.i(TAG,"doInBackground, Thread name " +Thread.currentThread().getName());

            //Dummy long operation
            int ctr=1;
            while(ctr<=duration){
                publishProgress("Time elapsed "+ ctr+ "secs");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                ctr++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.i(TAG,"onProgressUpdate, counter value "+values[0]+ "Thread name " +Thread.currentThread().getName());
            super.onProgressUpdate(values);
            Toast.makeText(MyBackgoundService.this,values[0],Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TAG,"onPostExecute, Thread name " +Thread.currentThread().getName());
            super.onPostExecute(aVoid);
            stopSelf();
        }
    }
}
