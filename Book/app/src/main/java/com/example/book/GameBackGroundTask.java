package com.example.book;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class GameBackGroundTask extends IntentService {
    public GameBackGroundTask(String name) {
        super("Back Ground Thread class");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("from onCreate");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        System.out.println("Calling from GameBackGroundTask");
    }
}
