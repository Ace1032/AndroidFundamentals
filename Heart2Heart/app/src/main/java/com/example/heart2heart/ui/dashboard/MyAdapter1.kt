package com.example.heart2heart.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heart2heart.R

class MyAdapter1(private val data: List<Event>):
    RecyclerView.Adapter<MyAdapter1.ViewHolder>(){

    class ViewHolder (eventView: View): RecyclerView.ViewHolder(eventView){
            val titleTextView: TextView = eventView.findViewById(R.id.titleTextView)
            val dateTextView: TextView = eventView.findViewById(R.id.dateTextView)
            val imageView: ImageView = eventView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.eventview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = data[position]
        holder.titleTextView.text = event.title
        holder.dateTextView.text = event.date
        holder.imageView.setImageResource(event.src)

    }

}