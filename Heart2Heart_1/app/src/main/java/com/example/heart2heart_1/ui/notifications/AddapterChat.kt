package com.example.heart2heart_1.ui.notifications

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heart2heart_1.R
import com.example.heart2heart_1.sampledata.ChatMessage


class AddapterChat(private val chatList: MutableList<ChatMessage>):
RecyclerView.Adapter<AddapterChat.ChatViewHolder>(){

    class ChatViewHolder(chatItem: View): RecyclerView.ViewHolder(chatItem) {
        val timeStamp: TextView = chatItem.findViewById<TextView?>(R.id.time_id)
        val message: TextView = chatItem.findViewById<TextView?>(R.id.message_id)
        val sender: TextView = chatItem.findViewById<TextView?>(R.id.sender_id)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message,parent,false)
        return ChatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.timeStamp.text = chatList[position].timeStamp.toString()
        holder.message.text = chatList[position].message
        holder.sender.text = chatList[position].sender


    }
    fun updateChatList(newData: List<ChatMessage>) {
        chatList.clear()
        Log.d("AddapterChat", "Updating chat list with ${newData.size} items")
        chatList.addAll(newData)
        notifyDataSetChanged()
    }


}