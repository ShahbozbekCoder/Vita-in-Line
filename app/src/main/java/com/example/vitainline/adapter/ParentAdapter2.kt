package com.example.vitainline.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vitainline.R
import com.example.vitainline.datas.ParentItem2
import com.example.vitainline.listener.NestedRecyclerViewListener

class ParentAdapter2(private val parentList: ArrayList<ParentItem2>): RecyclerView.Adapter<ParentAdapter2.MyViewHolder>(){

    private var recyclerViewListener: NestedRecyclerViewListener? = null
    inner class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        val nameMedicine : TextView = itemView.findViewById(R.id.textViewRecommend)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.rcRecommend)
        init {
            itemView.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout2,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val parentItem  = parentList[position]
        val childAdapter = ChildAdapter2(parentItem.times)
        holder.nameMedicine.text = parentItem.recommend
        holder.childRecyclerView.setHasFixedSize(true)
        holder.childRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.childRecyclerView.adapter = childAdapter
    }
}