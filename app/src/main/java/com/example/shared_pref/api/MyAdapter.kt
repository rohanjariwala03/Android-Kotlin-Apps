package com.example.shared_pref.api

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shared_pref.R

class MyAdapter(val context : Context, val userList : List<MyDataItem>) : RecyclerView.Adapter<MyAdapter.ViewHolder>( ) {
    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var userId : TextView = itemView.findViewById(R.id.userId)
        var title : TextView = itemView.findViewById(R.id.title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_api_data_items,parent,false)
         return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = userList[position].userId.toString()
        holder.title.text = userList[position].title.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}