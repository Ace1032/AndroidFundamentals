package com.example.heart2heart_1.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heart2heart_1.R
import com.example.heart2heart_1.sampledata.NewsArticles
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList: MutableList<NewsArticles>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                //val imageView: ImageView= itemView.findViewById(R.id.imageView)
                val titleTextView: TextView = itemView.findViewById(R.id.titleID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_article,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsArticle = newsList[position]
        holder.titleTextView.text = newsArticle.title
        //Picasso.get().load(newsArticle.imageUrl).into(holder.imageView)

    }
    fun updateNewsList(newData: List<NewsArticles>) {
        newsList.clear()
        newsList.addAll(newData)
        notifyDataSetChanged()

    }
}