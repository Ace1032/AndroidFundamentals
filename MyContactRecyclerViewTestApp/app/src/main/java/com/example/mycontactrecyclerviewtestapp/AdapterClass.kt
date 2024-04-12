package com.example.mycontactrecyclerviewtestapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val dataList: ArrayList<DataClass>):
    RecyclerView.Adapter<AdapterClass.ViewHolderClass>() {

    class ViewHolderClass (itemView:View):RecyclerView.ViewHolder(itemView){
            val name:TextView= itemView.findViewById(R.id.name_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView= LayoutInflater.from(parent.context
        ).inflate(R.layout.item_layout, parent,false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        var currentItem= dataList[position]
        holder.name.text= currentItem.name
    }
}