package com.example.totalgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private Button cal;
    private EditText weight;
    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText inch;
    private EditText feet;
    private TextView advice;
    private Button self_learn;
    private  String personal_goal;
    private double bmi_score=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setUpButtonListner();
        learnAboutYourSelf();
    }

    private void learnAboutYourSelf(){
        self_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent loginIntent=new Intent(MainActivity.this, LoginActivity.class);
                //startActivity(loginIntent);
            }
        });
    }

    private void setUpButtonListner() {
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
                //Intent demographicIntent= new Intent(MainActivity.this, demographic.class);
                //startActivity(demographicIntent);
            }
        });
    }

    private void setupBodyType() {
        ImageView body_t=findViewById(R.id.bodyImage);
        if(bmi_score<=16 && bmi_score>15){
            body_t.setImageResource(R.drawable.skinny2);
        }
        if(bmi_score<=17 && bmi_score>16){
            body_t.setImageResource(R.drawable.skinny1);
        }
        if(bmi_score<18.5 && bmi_score>15){
            body_t.setImageResource(R.drawable.skinny_build);
        }
        if(bmi_score<=25 && bmi_score>=18.5){
            body_t.setImageResource(R.drawable.lean_build2);
        }
        if(bmi_score<=30 && bmi_score>25){
            body_t.setImageResource(R.drawable.lean_build);
        }
        if(bmi_score<=35 && bmi_score>30){
            body_t.setImageResource(R.drawable.build);
        }
        if(bmi_score<=40 && bmi_score>35){
            body_t.setImageResource(R.drawable.build_overweight);
        }
        if(bmi_score>= 40 && bmi_score>45){
            body_t.setImageResource(R.drawable.over_weight_1);
        }
        if(bmi_score>45){
            body_t.setImageResource(R.drawable.over_weight_2);
        }
    }

    private void calculateBMI() {
        String ageS=age.getText().toString();
        String feetS=feet.getText().toString();
        String inchS=inch.getText().toString();
        String weightS=weight.getText().toString();
        //String adviceS=ageS+", Height:"+ feetS+"' "+inchS+", Weight:"+weightS;

        /*
        USC Units:
BMI = 703 × 	mass (lbs)/height^2 (in)= 703 × 160/702= 22.96 	kg/m2
         */
        if((Integer.parseInt(weightS)>350 || Integer.parseInt(weightS)<50) || (Integer.parseInt(feetS)>9 ||
                Integer.parseInt(feetS)<3) ||(Integer.parseInt(inchS)>12) ||
                (Integer.parseInt(ageS)<110 ||Integer.parseInt(ageS)>1 )){
            advice.setText("Please Input correct info!");
        } else {
            double bmiScore = 703 * (Integer.parseInt(weightS)) / Math.pow((Integer.parseInt(feetS)) * 12 + Integer.parseInt(inchS), 2);
            bmi_score = Math.round(bmiScore);
            advice.setText("Your BMI score is: " + Math.round(bmiScore));
        }
    }

    private void findView(){
        male = findViewById(R.id.maleID);
        female = findViewById(R.id.femaleID);
        age = findViewById(R.id.ageID);
        inch = findViewById(R.id.height_inchID);
        weight=findViewById(R.id.weightID);
        cal= findViewById(R.id.calculateID);
        feet=findViewById(R.id.height_feetID);
        advice=findViewById(R.id.adviceID);
        self_learn=findViewById(R.id.continue_button);
    }
}