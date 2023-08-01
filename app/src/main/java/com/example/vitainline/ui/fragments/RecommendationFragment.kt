package com.example.vitainline.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vitainline.R
import com.example.vitainline.ui.adapter.ParentAdapter2
import com.example.vitainline.databinding.FragmentRecomendationBinding
import com.example.vitainline.data.models.ChildItem2
import com.example.vitainline.data.models.ParentItem2

class RecommendationFragment : Fragment() {

    private var _binding: FragmentRecomendationBinding? = null
    private val binding get() = _binding!!
    private lateinit var myAdapter: ParentAdapter2
    private val recommentList = ArrayList<ParentItem2>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addToList()
        // Inflate the layout for this fragment
        _binding = FragmentRecomendationBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun addToList() {
        val childItem2 = ArrayList<ChildItem2>()
        childItem2.add(ChildItem2("8:00"))
        childItem2.add(ChildItem2("13:00"))
        childItem2.add(ChildItem2("17:00"))
        recommentList.add(ParentItem2("Qon bosimini o'lchash",childItem2))
        val childItem1 = ArrayList<ChildItem2>()
        childItem1.add(ChildItem2("8:00"))
        childItem1.add(ChildItem2("13:00"))
        childItem1.add(ChildItem2("17:00"))
        recommentList.add(ParentItem2("Yurak urishini o'lchash",childItem1))
        val childItem3 = ArrayList<ChildItem2>()
        childItem3.add(ChildItem2("8:00"))
        childItem3.add(ChildItem2("13:00"))
        childItem3.add(ChildItem2("17:00"))
        recommentList.add(ParentItem2("Doktordan maslahat olish",childItem3))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = ParentAdapter2(recommentList)
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.imgStory.setOnClickListener {
            findNavController().navigate(R.id.action_recommendationFragment_to_fragmentRecHistoryFragment)
        }
        binding.mainRcRecommend.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}