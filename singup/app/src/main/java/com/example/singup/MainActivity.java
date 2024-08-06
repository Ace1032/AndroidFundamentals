package com.example.singup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGoup;
    String Gender;
    RadioButton male,female;
    EditText profileName, emailID;
    Button submit_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGoup=findViewById(R.id.gender);
        profileName= findViewById(R.id.profileName);
        emailID= findViewById(R.id.emailID);
        submit_id=findViewById(R.id.submit_id);

        submit_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkAllComplete())
                    System.out.println("Imara");
            }
        });


    }

    public boolean checkAllComplete(){
        Editable pName=profileName.getText();
        Editable email=emailID.getText();
        int selectedGNumber=rGoup.getCheckedRadioButtonId();
        if(selectedGNumber==1)
            Gender="Male";
        else if(selectedGNumber==2)
            Gender="Female";

        return (pName!=null && email!=null && email!=null && Gender!=null);
    }
}
