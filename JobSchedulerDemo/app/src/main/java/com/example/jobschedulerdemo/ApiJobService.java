package com.example.jobschedulerdemo;

import static android.content.ContentValues.TAG;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.util.Log;

public class ApiJobService extends JobService {

    private static final String Tag="ApiFetchJobService";
    @Override
    public boolean onStartJob(JobParameters params) {
        new AsyncTask<Void, Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                fetchApiData();
                jobFinished(params,false);
                return null;
            }


        }.execute();
        return true;
    }

    private void fetchApiData() {

        Log.d(TAG, "Fetching API data...");
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "Job stopped before completion");
        return false;
    }
}
