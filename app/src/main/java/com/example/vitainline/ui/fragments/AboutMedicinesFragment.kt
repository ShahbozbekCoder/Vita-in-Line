package com.example.vitainline.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.vitainline.databinding.FragmentAboutMedicinesBinding
import com.example.vitainline.datas.MedicineItem

class AboutMedicinesFragment : Fragment() {

    private var _binding: FragmentAboutMedicinesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAboutMedicinesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imgBackMedicines.setOnClickListener {
            findNavController().popBackStack()
        }
        val info = arguments?.getSerializable("about_medicines") as MedicineItem
        binding.imageOfMedicine.setImageResource(info.image)
        binding.medicineName.text = info.name
        binding.medicineInfo.text = info.status
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}