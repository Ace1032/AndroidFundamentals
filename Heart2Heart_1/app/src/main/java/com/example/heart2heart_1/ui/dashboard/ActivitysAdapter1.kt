package com.example.heart2heart_1.ui.dashboard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heart2heart_1.R
import com.example.heart2heart_1.sampledata.ActivityItem

class ActivitysAdapter1(private val activityList: MutableList<ActivityItem>) :
    RecyclerView.Adapter<ActivitysAdapter1.ActivityViewHolder>() {

    class ActivityViewHolder(activtyItem: View): RecyclerView.ViewHolder(activtyItem) {
        val titleTextView: TextView = activtyItem.findViewById(R.id.activitytitle)
        val dateTextView: TextView = activtyItem.findViewById(R.id.activty_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item,parent,false)
        return ActivityViewHolder(view)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        Log.d("ActivitysAdapter1", "${activityList[position].title}")
        holder.titleTextView.text= activityList[position].title
       holder.dateTextView.text = activityList[position].date
    }
    fun updateActivityList(newData: List<ActivityItem>) {
        Log.d("ActivitysAdapter1", "Updating activity list with ${newData.size} items")
        activityList.clear()
        activityList.addAll(newData)
        notifyDataSetChanged()
    }

}
