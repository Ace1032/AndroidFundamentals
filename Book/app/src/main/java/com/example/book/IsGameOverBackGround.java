package com.example.book;


import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class IsGameOverBackGround extends IntentService {

    public IsGameOverBackGround(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void doCheck(){
            Board Gboard=Board.getBoard();
            Boolean[][] board=Gboard.passBoardArray();
            pirntBoard(board);
    }

    public void pirntBoard(Boolean[][] board){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                System.out.print("ap "+board[i][j]+" ");
            }
            System.out.println();
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        System.out.println("Hey Time to check who won");
        //doCheck();
    }
}
