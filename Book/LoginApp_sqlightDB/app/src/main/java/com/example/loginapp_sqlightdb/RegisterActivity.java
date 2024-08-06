package com.example.loginapp_sqlightdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    Button go_back;
    Button register;
    EditText f_name;
    EditText l_name;
    EditText address;
    EditText phone_n;
    EditText dob;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        settAllContentViews();
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backto_mainActivity=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(backto_mainActivity);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             UserProfile uf;
            //Toast.makeText(RegisterActivity.this, phone_n.getText().toString(),Toast.LENGTH_LONG).show();
             try{
                 uf=new UserProfile(f_name.getText().toString(),l_name.getText().toString(),
                         dob.getText().toString(),address.getText().toString(),phone_n.getText().toString(),
                         password.getText().toString()
                 );

             }catch (Exception ex){
                 Toast.makeText(RegisterActivity.this,
                         "Error from Creating profile!",
                         Toast.LENGTH_LONG).show();
                 uf =new UserProfile("ERROR",null,null,null,"(000)000 0000",null);
             }
             Toast.makeText(RegisterActivity.this,uf.toString(),Toast.LENGTH_LONG).show();
              //  DatabaseHelper db_helper= new DatabaseHelper(RegisterActivity.this);
             //db_helper.addOne(uf);


            }


        });


    }

    private void settAllContentViews() {
        go_back=findViewById(R.id.id_back_re_b);
        register=findViewById(R.id.id_register_B);
        f_name=findViewById(R.id.id_firstname);
        l_name=findViewById(R.id.id_lastname);
        address=findViewById(R.id.id_address);
        phone_n=findViewById(R.id.id_phonenumber);
        dob=findViewById(R.id.id_dob);
        password=findViewById(R.id.id_password);

    }

}