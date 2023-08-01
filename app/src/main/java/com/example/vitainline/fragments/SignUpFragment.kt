package com.example.vitainline.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.vitainline.R
import com.example.vitainline.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

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
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_registerFragment)
        }

        binding.signUpButton.setOnClickListener {
            val login = binding.edtLogin.text.toString()
            val password = binding.etPassword.text.toString()
            Log.d("TAG3", "onViewCreated: $login $password")
            var trueLogin = arguments?.getString("login")
            var truePassword = arguments?.getString("password")
            Log.d("TAG1", "onViewCreated:$login  $password")
            if (trueLogin == null && truePassword == null){
                trueLogin = "05.05.2023"
                truePassword = "AA1234567"
            }
            Log.d("TAG2", "onViewCreated:$login  $password")
            if (login == trueLogin && password == truePassword) {
                findNavController().navigate(R.id.action_signUpFragment_to_mainPageFragment)
                Log.d("TAG3", "onViewCreated: $trueLogin $truePassword")
            } else {
                binding.textViewInfo.visibility = View.VISIBLE
                binding.textViewInfo2.visibility = View.VISIBLE
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}