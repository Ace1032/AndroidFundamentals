package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 Button b_00,b_01,b_02,
         b_10,b_11,b_12,
         b_20,b_21,b_22, login;


 Board game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_00=findViewById(R.id.b_00);
        b_01=findViewById(R.id.b_01);
        b_02=findViewById(R.id.b_02);
        b_10=findViewById(R.id.b_10);
        b_11=findViewById(R.id.b_11);
        b_12=findViewById(R.id.b_12);
        b_20=findViewById(R.id.b_20);
        b_21=findViewById(R.id.b_21);
        b_22=findViewById(R.id.b_22);
        login=findViewById(R.id.login_id);

        b_00.setOnClickListener(this);
        b_01.setOnClickListener(this);
        b_02.setOnClickListener(this);
        b_10.setOnClickListener(this);
        b_11.setOnClickListener(this);
        b_12.setOnClickListener(this);
        b_20.setOnClickListener(this);
        b_21.setOnClickListener(this);
        b_22.setOnClickListener(this);

        login.setOnClickListener(this);
        game=Board.getBoard();
    }

    public void checkGameStatus(){
        //Intent intent=new Intent(this,GameBackGroundTask.class);
        //startService(intent);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_00:
                if(b_00.getText().toString().equals("")) {
                    game.setKey(0, 0);
                    checkGameStatus();
                    Intent intent=new Intent(this,GameBackGroundTask.class);
                    startService(intent);
                    if (game.getValue(0, 0))
                        b_00.setText("x");
                    else
                        b_00.setText("o");
                }
                break;
            case R.id.b_01:
                if(b_01.getText().toString().equals("")) {
                    game.setKey(0, 1);
                    checkGameStatus();
                    if (game.getValue(0, 1))
                        b_01.setText("x");
                    else
                        b_01.setText("o");
                }
                break;
            case R.id.b_02:
                if(b_02.getText().toString().equals("")) {
                    game.setKey(0, 2);
                    checkGameStatus();
                    if (game.getValue(0, 2))
                        b_02.setText("x");
                    else
                        b_02.setText("o");
                }
                break;
            case R.id.b_10:
                if(b_10.getText().toString().equals("")) {
                    game.setKey(1, 0);
                    checkGameStatus();
                    if (game.getValue(1, 0))
                        b_10.setText("x");
                    else
                        b_10.setText("o");
                }
                break;
            case R.id.b_11:
                if(b_11.getText().toString().equals("")) {
                    game.setKey(1, 1);
                    checkGameStatus();
                    if (game.getValue(1, 1))
                        b_11.setText("x");
                    else
                        b_11.setText("o");
                }
                break;
            case R.id.b_12:
                if(b_12.getText().toString().equals("")) {
                    game.setKey(1, 2);
                    checkGameStatus();
                    if (game.getValue(1, 2))
                        b_12.setText("x");
                    else
                        b_12.setText("o");
                }
                break;
            case R.id.b_20:
                if(b_20.getText().toString().equals("")) {
                    game.setKey(2, 0);
                    checkGameStatus();
                    if (game.getValue(2, 0))
                        b_20.setText("x");
                    else
                        b_20.setText("o");
                }
                break;
            case R.id.b_21:
                if(b_21.getText().toString().equals("")) {
                    game.setKey(2, 1);
                    checkGameStatus();
                    if (game.getValue(2, 1))
                        b_21.setText("x");
                    else
                        b_21.setText("o");
                }
                break;
            case R.id.b_22:
                if(b_22.getText().toString().equals("")) {
                    game.setKey(2, 2);
                    checkGameStatus();
                    if (game.getValue(2, 2))
                        b_22.setText("x");
                    else
                        b_22.setText("o");
                }
                break;
            case R.id.login_id:


        }
    }
}
