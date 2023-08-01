package com.example.vitainline.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vitainline.databinding.ItemLayoutMedicineBinding
import com.example.vitainline.datas.MedicineItem
import com.example.vitainline.listener.NestedRecyclerViewListener

class MedicineAdapter : ListAdapter<MedicineItem, MedicineAdapter.ItemViewHolder>(MyDiffUtil()) {

    private var recyclerViewListener: NestedRecyclerViewListener? = null
    inner class ItemViewHolder(private val binding: ItemLayoutMedicineBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medicineItem: MedicineItem) {
            binding.photoOfMedicine.setImageResource(medicineItem.image)
            binding.nameOfMedicine.text = medicineItem.name
            binding.statusOfMedicine.text = medicineItem.status
        }
        init {
            binding.root.setOnClickListener {
                recyclerViewListener?.onItemClick(adapterPosition)
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<MedicineItem>() {

        override fun areItemsTheSame(oldItem: MedicineItem, newItem: MedicineItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MedicineItem, newItem: MedicineItem): Boolean {
            return oldItem == newItem
        }
    }

    fun setListener(listener: NestedRecyclerViewListener){
        recyclerViewListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MedicineAdapter.ItemViewHolder {
        val binding =
            ItemLayoutMedicineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicineAdapter.ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}