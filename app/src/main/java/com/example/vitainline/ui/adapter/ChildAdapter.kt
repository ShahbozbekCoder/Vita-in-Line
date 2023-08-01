package com.example.vitainline.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vitainline.R
import com.example.vitainline.data.models.ChildItem

class ChildAdapter(private val childList: List<ChildItem>): RecyclerView.Adapter<ChildAdapter.CHilViewHolder>() {

    inner class CHilViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val time: TextView = itemView.findViewById(R.id.textViewTime)
        val medicineCount: TextView = itemView.findViewById(R.id.textViewQuantity)
        val status: TextView = itemView.findViewById(R.id.textViewStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CHilViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CHilViewHolder(view)
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: CHilViewHolder, position: Int) {
        val childItem = childList[position]
        holder.time.text = childItem.time
        holder.medicineCount.text = childItem.medicineCount
        holder.status.text = childItem.status
    }
}