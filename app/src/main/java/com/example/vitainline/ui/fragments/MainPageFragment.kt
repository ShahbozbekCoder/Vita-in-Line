package com.example.vitainline.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.vitainline.R
import com.example.vitainline.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {

    private var _binding: FragmentMainPageBinding? = null
    private val binding get() = _binding!!
    private val TAG = "MainPageFragment"

    override fun onResume() {
        super.onResume()
        val languages = resources.getStringArray(R.array.languages)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, languages)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fullName = arguments?.getString("fullName","Xurshidov M.").toString()
        var number = 0
        fullName.let {
            for (i in 0..fullName.lastIndex){
                if (fullName[i] == ' ') {
                    number = i
                    break
                }
            }
            val firstName = fullName.substring(0,number + 2) + "."
            binding.textViewUserName.text = firstName
        }
        val login = arguments?.getString("login","05.05.2023").toString()
        val region = arguments?.getString("region","Buxoro").toString()
        val work = arguments?.getString("work","Ishsiz").toString()
        binding.textViewBirthdayDate.text = login
        binding.textViewBirthdayRegion.text = region
        binding.textViewWorkCompany.text = work
        Log.d(TAG, "onViewCreated: $fullName\n$login\n$region\n$work")

        binding.imgDavolanish.setOnClickListener {
            findNavController().navigate(R.id.action_mainPageFragment_to_treatmentFragment)
        }

        binding.imgTavsiyanoma.setOnClickListener {
            findNavController().navigate(R.id.action_mainPageFragment_to_recommendationFragment)
        }

        binding.buttonMedicines.setOnClickListener {
            findNavController().navigate(R.id.action_mainPageFragment_to_medicinesFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}