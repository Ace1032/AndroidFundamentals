package com.example.testsqllight;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText customer_name, customer_age;
    Button add, view_all;
    Switch active_customer;
    ListView lv_customerList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAllViews();
        DatabaseHelper db_customer=new DatabaseHelper(this);
        //Customer customer=null;
      try {
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(customer_name!=null && customer_age!=null){
                        Customer customer=new Customer(customer_name.getText().toString(),
                                Integer.parseInt(customer_age.getText().toString()),1);
                        boolean addSu = db_customer.addOne(customer);
                        if(addSu){
                            Toast.makeText(MainActivity.this,"ADDING IS Susesful!",
                                    Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this, "ADDING IS Not GOOD",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }catch (Exception ex){
    Toast.makeText(MainActivity.this,"Error from add Button!", Toast.LENGTH_SHORT).show();
        }

    try{
        view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DatabaseHelper db=new DatabaseHelper(MainActivity.this);
                List<Customer> customer_list= new ArrayList<>();
                customer_list=db_customer.getList();

                ArrayAdapter arrayAdapter=
                        new ArrayAdapter<Customer>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,
                                customer_list);
                lv_customerList.setAdapter(arrayAdapter);


                //Toast.makeText(MainActivity.this,customer_list.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }catch (Exception ex){
        Toast.makeText(MainActivity.this,"List view error!",Toast.LENGTH_LONG).show();
    }

    }

    private void setAllViews(){
        customer_name=findViewById(R.id.et_name);
        customer_age=findViewById(R.id.et_age);
        active_customer=findViewById(R.id.ac_switch);
        add=findViewById(R.id.addButton);
        view_all=findViewById(R.id.viewButton);
        lv_customerList = findViewById(R.id.customerList);
    }
}