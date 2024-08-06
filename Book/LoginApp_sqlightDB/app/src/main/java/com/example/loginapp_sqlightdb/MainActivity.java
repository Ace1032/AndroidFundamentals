package com.example.loginapp_sqlightdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText pass;
    Button login;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContentView();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_activity=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(register_activity);
            }
        });

    }

    private void getContentView(){
        username= findViewById(R.id.id_username);
        pass=findViewById(R.id.id_password);
        login=findViewById(R.id.id_login_B);
        register=findViewById(R.id.id_register_b);
    }
}