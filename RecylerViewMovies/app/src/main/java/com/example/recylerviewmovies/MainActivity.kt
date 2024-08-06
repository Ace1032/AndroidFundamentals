package com.example.recylerviewmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.recylerviewmovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var value :Project
    private lateinit var list:ArrayList<Project>
    private lateinit var list_Recyclerview:RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list_Recyclerview= binding.recyclerViewProjects
            value =Project(
            "First view",
            "this movies is cool", 1
        );
        list.add(value)


    }
}