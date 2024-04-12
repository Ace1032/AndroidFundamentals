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
            //var button_v:Button= itemView.findViewById(R.id.name_id)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView= LayoutInflater.from(parent.context
        ).inflate(R.layout.item_layout, parent,false)
        Log.d("mesa", "OnCreateMethoad has been clled")
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        Log.d("mesa", "getItemCount has been clled")
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        var currentItem= dataList[position]
        holder.name.text= currentItem.name
        Log.d("mesa", "OnBindViewHolder has been clled")
    }
}