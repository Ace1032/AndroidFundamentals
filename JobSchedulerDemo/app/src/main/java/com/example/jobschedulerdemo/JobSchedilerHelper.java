package com.example.jobschedulerdemo;

import static android.content.ContentValues.TAG;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.util.Log;

public class JobSchedilerHelper {
    public static void scheduleJob(Context context){
        JobScheduler jobScheduler= (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo jobInfo= JobInfoBuilder.getJobInfo(context);
        Log.d("TRACK JOB", jobInfo.toString());
        jobScheduler.schedule(jobInfo);

    }
}
