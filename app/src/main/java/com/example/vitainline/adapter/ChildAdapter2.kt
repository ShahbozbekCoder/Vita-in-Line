package com.example.vitainline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vitainline.R
import com.example.vitainline.datas.ChildItem2

class ChildAdapter2(private val childList: ArrayList<ChildItem2>): RecyclerView.Adapter<ChildAdapter2.CHilViewHolder>() {

    inner class CHilViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val time: TextView = itemView.findViewById(R.id.textViewTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CHilViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout2,parent,false)
        return CHilViewHolder(view)
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: CHilViewHolder, position: Int) {
        val childItem = childList[position]
        holder.time.text = childItem.time
    }
}