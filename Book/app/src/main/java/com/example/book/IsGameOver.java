package com.example.book;

public class IsGameOver implements Runnable {
    public Boolean[][] board= new Boolean[3][3];

    public IsGameOver(Boolean [][] board){
        board=board;
    }
    @Override
    public void run() {
        boolean gameOver=false;

        while(!gameOver) {
            System.out.println("Game over" + Thread.currentThread().getName());
            //isDone();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public boolean isDone(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                System.out.print("ap "+board[i][j]+" ");
            }
            System.out.println();
        }
        return true;
    }
}
