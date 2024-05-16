package com.example.jobschedulerdemo;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;

public class JobInfoBuilder {

    public static JobInfo getJobInfo(Context context){
        ComponentName componentName= new ComponentName(context, ApiJobService.class);
        JobInfo.Builder builder= new JobInfo.Builder(123, componentName)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)// wifi only
                    .setRequiresBatteryNotLow(true) //Call requires API level 26 (current min is 24): android.app.job.JobInfo.Builder#setRequiresBatteryNotLow
                    .setRequiresDeviceIdle(false)
                    .setPersisted(true);

        return builder.build();

    }
}
