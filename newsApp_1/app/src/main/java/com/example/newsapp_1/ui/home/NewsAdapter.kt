package com.example.newsapp_1.ui.home

import android.os.Build.VERSION_CODES.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp_1.Article
import com.example.newsapp_1.R

class NewsAdapter(private val newsList: List<Article>)
    :RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


   inner class NewsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        private val news_titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

       fun bind(newsItem: Article) {
           // Bind data to views here
           news_titleTextView.text = newsItem.title
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem= newsList[position]
        holder.bind(newsItem)
    }

}