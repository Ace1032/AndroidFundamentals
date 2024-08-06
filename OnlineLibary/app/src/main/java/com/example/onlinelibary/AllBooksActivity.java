package com.example.onlinelibary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private ArrayList<Book> books=new ArrayList<>();
    private RecyclerView booksRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        booksRecyclerView=(RecyclerView)findViewById(R.id.booksRecyleView);

        BooksRecViewAdapter adapter=new BooksRecViewAdapter(this);
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Util util=new Util();
        adapter.setBooks(util.getAllBooks());
    }

}
