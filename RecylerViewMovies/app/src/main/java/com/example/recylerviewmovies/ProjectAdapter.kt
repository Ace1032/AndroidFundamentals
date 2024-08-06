package com.example.recylerviewmovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ProjectAdapter(private val projects:List<Project>): RecyclerView.Adapter<ProjectViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ProjectViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        val project = projects[position]
        holder.apply {
            binding.name.text= project.name
            binding.description.text = project.discription

        }


    }
}

     class ProjectViewHolder (val binding:ListItemBinding):RecyclerView.ViewHolder(bindin.root){



        }

