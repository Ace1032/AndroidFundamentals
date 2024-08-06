package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);
        ListView starterList=findViewById(R.id.starterList_id);

        Dish[] starter_dishes={
                new Dish("Maki","Mushroom and tofu maki",13.50),
                new Dish("Urmaki","Egg and avocado uramaki", 15),
                new Dish("Soup","Melon and lemon soup", 12 ),
                new Dish("Mousse", "Coconut and chocolate mousse", 14)
               };

        ArrayAdapter<Dish> dishAdapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,starter_dishes);

        starterList.setAdapter(dishAdapter);



    }
}