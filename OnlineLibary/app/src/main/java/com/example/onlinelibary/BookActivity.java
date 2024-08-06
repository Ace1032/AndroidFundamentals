package com.example.onlinelibary;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private TextView bookName,author,description;
    private ImageView bookImage;
    private Button wishButton, alreadyButton;
    private Book theBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book);
        initAllAtibutes();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        String id=intent.getStringExtra("bookId");
        //temp
        //System.out.println("pass id "+id);
        //bookName.setText("Imara");
        final Util util=new Util();
        ArrayList<Book> books=util.getAllBooks();

        for(Book b: books){
            if(id.equals(b.getId())){
                bookName.setText(b.getName());
                author.setText(b.getAuthor());
                description.setText(b.getDescription());
                Glide.with(this).asBitmap().load(b.getImageURL()).into(bookImage);
                theBook=b;
            }
        }

        wishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                util.addWantsBooks(theBook);
                Toast alertAddBook= Toast.makeText(getApplicationContext(),theBook.getName()+
                        " added to the wish list.", Toast.LENGTH_SHORT);
                alertAddBook.show();
            }
        });

    }


    public void initAllAtibutes(){
        bookName=(TextView) findViewById(R.id._idBookName);
        author=(TextView)findViewById(R.id._idAuthor);
        description=(TextView)findViewById(R.id._idDescription);
        bookImage=(ImageView) findViewById(R.id._idBookIma);

        wishButton=(Button) findViewById(R.id.idWishButton);
        alreadyButton=(Button) findViewById(R.id.idAlreadyButton);
    }

}
