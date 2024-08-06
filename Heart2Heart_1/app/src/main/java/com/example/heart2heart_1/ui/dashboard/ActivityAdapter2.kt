package com.example.heart2heart_1.ui.dashboard


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heart2heart_1.R
import com.example.heart2heart_1.sampledata.ActivityItem

class ActivityAdapter2(private val activityList: MutableList<ActivityItem>) :
    RecyclerView.Adapter<ActivityAdapter2.ActivityViewHolder>() {
    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.activitytitle)
        val dateTextView: TextView = itemView.findViewById(R.id.activty_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item,parent,false)
        return ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
       return activityList.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        holder.titleTextView.text= activityList[position].title
        holder.dateTextView.text = activityList[position].date

    }

    fun updateActivityList(newData: List<ActivityItem>) {
        activityList.clear()
        activityList.addAll(newData)
        notifyDataSetChanged()
    }

}