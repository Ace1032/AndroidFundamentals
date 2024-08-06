package com.example.onlinelibary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button seeAllBooks, curReadingBooks, wantBooks, readBooks, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validateButtons();

        seeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });

    }

    private void validateButtons() {
        seeAllBooks=(Button)findViewById(R.id.seeAllBooksId);
        curReadingBooks=(Button)findViewById(R.id.currentlyReadingBooksId);
        wantBooks=(Button)findViewById(R.id.wantsToReadBooksId);
        readBooks=(Button)findViewById(R.id.alreadyReadBooksId);
        about=(Button)findViewById(R.id.aboutId);
    }
}
