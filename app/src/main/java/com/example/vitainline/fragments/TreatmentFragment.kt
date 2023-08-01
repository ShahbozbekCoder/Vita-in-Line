package com.example.vitainline.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vitainline.R
import com.example.vitainline.adapter.ParentAdapter
import com.example.vitainline.databinding.FragmentTreatmenBinding
import com.example.vitainline.datas.ChildItem
import com.example.vitainline.datas.ParentItem
import com.example.vitainline.listener.NestedRecyclerViewListener

class TreatmentFragment : Fragment() {

    private var _binding: FragmentTreatmenBinding? = null
    private val binding get() = _binding!!
    private val parentList = ArrayList<ParentItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        addDataToList()
        _binding = FragmentTreatmenBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun addDataToList() {
        val childItem1 = ArrayList<ChildItem>()
        childItem1.add(ChildItem("8:00","1 ta","Ovqatdan oldin"))
        childItem1.add(ChildItem("12:00","2 ta","Ovqatdan keyin"))
        childItem1.add(ChildItem("18:00","1 ta","Ovqatdan mahal"))
        parentList.add(ParentItem("Parasetamol",childItem1))
        val childItem2 = ArrayList<ChildItem>()
        childItem2.add(ChildItem("9:00","2 ta","Ovqatdan keyin"))
        childItem2.add(ChildItem("11:00","2 ta","Ovqatdan mahal"))
        childItem2.add(ChildItem("17:00","1 ta","Ovqatdan oldin"))
        parentList.add(ParentItem("Aspirin",childItem2))
        val childItem3 = ArrayList<ChildItem>()
        childItem3.add(ChildItem("8:00","1 ta","Ovqatdan oldin"))
        childItem3.add(ChildItem("12:00","2 ta","Ovqatdan mahal"))
        childItem3.add(ChildItem("17:00","2 ta","Ovqatdan keyin"))
        parentList.add(ParentItem("Sifloks",childItem3))
        val childItem4 = ArrayList<ChildItem>()
        childItem4.add(ChildItem("9:00","2 ta","Ovqatdan oldin"))
        childItem4.add(ChildItem("13:00","2 ta","Ovqatdan keyin"))
        childItem4.add(ChildItem("18:00","2 ta","Ovqatdan mahal"))
        parentList.add(ParentItem("Mezim",childItem4))
        val childItem5 = ArrayList<ChildItem>()
        childItem5.add(ChildItem("2:00","2 ta","Ovqatdan keyin"))
        childItem5.add(ChildItem("12:00","1 ta","Ovqatdan mahal"))
        childItem5.add(ChildItem("17:00","1 ta","Ovqatdan oldin"))
        parentList.add(ParentItem("Omez",childItem5))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentAdapter = ParentAdapter(parentList)
        binding.mainRc.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = parentAdapter
        }
        parentAdapter.setListener(object :NestedRecyclerViewListener{
            override fun onItemClick(position: Int) {
                findNavController().navigate(R.id.action_treatmentFragment_to_bottomSheetDialog)
            }
        })
        binding.imgStory.setOnClickListener {
            findNavController().navigate(R.id.action_treatmentFragment_to_treatmentHistoryFragment)
        }
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}