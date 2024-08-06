package com.example.book;

import android.content.Intent;

import java.time.Instant;

public class Board {

    private static Board GBoard=null;
    private Boolean [][] board=new Boolean[3][3];
    private Boolean turned=true;

    //IsGameOverBackGround backGround;

    private Board(){
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board.length;j++){
                board[i][j]=null;
            }
        }
       // backGround=new IsGameOverBackGround();

    }
    public Boolean[][] passBoardArray(){
        return board;
    }
    public static Board getBoard(){
        if(GBoard==null)
            return new Board();
        return GBoard;
    }
    public void setKey(int x, int y){
        board[x][y]=turned;
        changeTurned();
    }
    public void pirntBoard(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                System.out.print("ap "+board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public boolean getValue(int x, int y){
        return board[x][y];
    }
    private void changeTurned(){
        if(turned==true)
            turned=false;
        else
            turned=true;
    }


}
