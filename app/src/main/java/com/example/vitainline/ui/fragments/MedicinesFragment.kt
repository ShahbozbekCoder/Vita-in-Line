package com.example.vitainline.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vitainline.R
import com.example.vitainline.adapter.MedicineAdapter
import com.example.vitainline.databinding.FragmentMedicinesBinding
import com.example.vitainline.datas.MedicineItem
import com.example.vitainline.listener.NestedRecyclerViewListener


class MedicinesFragment : Fragment() {

    private var _binding: FragmentMedicinesBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: MedicineAdapter
    private lateinit var medicinesList: ArrayList<MedicineItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMedicinesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addList()
        myAdapter = MedicineAdapter()
        myAdapter.submitList(medicinesList)
        binding.medicineRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
        myAdapter.setListener(object : NestedRecyclerViewListener {
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putSerializable("about_medicines", medicinesList[position])
                findNavController().navigate(
                    R.id.action_medicinesFragment_to_aboutMedicinesFragment,
                    bundle
                )
            }
        })

        binding.imgBackMedicines.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun addList() {
        medicinesList = ArrayList()
        medicinesList.add(
            MedicineItem(
                "Parasetamol 500 mg",
                "Isitma tushiruvchi",
                R.drawable.paracetamol2
            )
        )
        medicinesList.add(
            MedicineItem(
                "No Shpa 500 mg",
                "Og'riq qoldiruvchi",
                R.drawable.paracetamol2
            )
        )
        medicinesList.add(
            MedicineItem(
                "Mezim",
                "Ovqat hazm qiluvchi",
                R.drawable.paracetamol2
            )
        )
        medicinesList.add(
            MedicineItem(
                "Omez",
                "Jig'ildon qaynashini qoldiruvchi",
                R.drawable.paracetamol2
            )
        )
        medicinesList.add(
            MedicineItem(
                "Aspirin",
                "Qonni suyiltiruvchi",
                R.drawable.paracetamol2
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}