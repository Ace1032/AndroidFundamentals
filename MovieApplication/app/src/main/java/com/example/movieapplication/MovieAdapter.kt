package com.example.movieapplication

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapplication.databinding.ItemMovieBinding

class MovieAdapter: ListAdapter<Movie,MovieAdapter.MovieViewHolder>(MovieDiffcallback()){


    inner class MovieViewHolder (
        private val binding: ItemMovieBinding):RecyclerView.ViewHolder(binding.root){

            fun bind(movie:Movie){
                binding.textTitle.text= movie.title
                binding.textGenre.text=movie.genre
                binding.textYear.text=movie.year.toString()
            }

         companion object {
            fun create(parent: ViewGroup): MovieViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(inflater, parent, false)
                return MovieViewHolder(binding)
            }
        }


    }

    class MovieDiffcallback: DiffUtil.ItemCallback<Movie>(){
        override  fun areItemsTheSame(oldItem: Movie, newItem: Movie):Boolean{
            if(oldItem.title==newItem.title){return true}
            else return false

        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem== newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.Companion.create(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return
    }

}