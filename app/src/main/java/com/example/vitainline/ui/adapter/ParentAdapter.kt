package com.example.vitainline.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vitainline.R
import com.example.vitainline.data.models.ParentItem
import com.example.vitainline.ui.listener.NestedRecyclerViewListener

class ParentAdapter(private val parentList: List<ParentItem>): RecyclerView.Adapter<ParentAdapter.MyViewHolder>(){

    private var recyclerViewListener: NestedRecyclerViewListener? = null
    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val nameMedicine : TextView = itemView.findViewById(R.id.textViewMedicineName1)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.rc1)
        init {
            itemView.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }
    }

    fun setListener(listener: NestedRecyclerViewListener){
        recyclerViewListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val parentItem  = parentList[position]
        val childAdapter = ChildAdapter(parentItem.order)
        holder.nameMedicine.text = parentItem.medicine
        holder.childRecyclerView.setHasFixedSize(true)
        holder.childRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.childRecyclerView.adapter = childAdapter
    }
}