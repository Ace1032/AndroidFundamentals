package com.example.teastapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView backArrow, settings, voice, cart, car;
    private EditText nameEditText, emailEditText, websiteEditText, descriptionEditText;
    private Spinner countrySpinner;
    private RadioGroup sexRadioGroup;
    private Button btnFinish;

    private ArrayList<String> countries;
    private String CountryName="";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intitWidgets();
        addCountries();

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    finishRegistration();
            }


        });
    }


    private void finishRegistration() {
        String name=nameEditText.getText().toString();
        String email=emailEditText.getText().toString();
        String description=descriptionEditText.getText().toString();
        String website=websiteEditText.getText().toString();

        String gender="";

        int checkedRb=sexRadioGroup.getCheckedRadioButtonId();

        switch (checkedRb){
            case R.id.male:
                gender="Male";
                break;
            case R.id.female:
                gender="Female";
                break;
            case R.id.other:
                gender="Other";
                break;
                default:
                    break;

        }

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                CountryName=countries.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                CountryName="No Country Selected";
            }
        });
    }

    private void addCountries() {
        countries=new ArrayList<>();

        countries.add("United States");
        countries.add("United Kingdom");
        countries.add("Swisterland");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,countries);
        countrySpinner.setAdapter(adapter);
    }


    private void intitWidgets() {
        backArrow=(ImageView) findViewById(R.id.backArrow);
        settings=(ImageView) findViewById(R.id.settings);
        voice=(ImageView) findViewById(R.id.voiceImageView);
        cart=(ImageView) findViewById(R.id.shoppingcartImageView);
        car=(ImageView) findViewById(R.id.shoppingcartImageView);

        nameEditText =(EditText)findViewById(R.id.nameEditText);
        emailEditText=(EditText)findViewById(R.id.emailEditText);
        websiteEditText=(EditText)findViewById(R.id.webEditTextId);
        descriptionEditText=(EditText)findViewById(R.id.descriptionEditText);

        countrySpinner=(Spinner)findViewById(R.id.countrySpinner);

        sexRadioGroup = (RadioGroup)findViewById(R.id.genderRadioGroup);

        btnFinish=(Button)findViewById(R.id.btnFinish);
    }

    private void initonClickListneres(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"BackArrow",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
