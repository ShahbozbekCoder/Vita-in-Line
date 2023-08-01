package com.example.vitainline.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.vitainline.R
import com.example.vitainline.databinding.FragmentRegisterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.SimpleDateFormat
import java.util.*

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val TAG = "RegisterFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(calendar)

        }
        binding.editDateLayout.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        binding.imgBack.setOnClickListener {

        }

        val regions = arrayOf(
            "Andijon",
            "Farg'ona",
            "Namangan",
            "Toshkent",
            "Sirdaryo",
            "Jizzax",
            "Samarqand",
            "Qashqadaryo",
            "Surxondaryo",
            "Buxoro",
            "Navoiy",
            "Xorazm",
            "Qoraqalpoqg'iston"
        )
        var selectedItemIndex = 0
        var selectedItem = regions[selectedItemIndex]
        binding.editRegionLayout.setOnClickListener {

            val alertDialog = MaterialAlertDialogBuilder(requireContext())
            alertDialog.setTitle("Viloyatni tanlang")
                .setSingleChoiceItems(regions, selectedItemIndex) { _, which ->
                    selectedItemIndex = which
                    selectedItem = regions[which]
                }.setPositiveButton("Ok") { _, _ ->
                    Toast.makeText(requireContext(), "$selectedItem tanlandi", Toast.LENGTH_SHORT)
                        .show()
                    installRegion(selectedItem)
                }.setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(requireContext(), "Viloyat tanlanmadi", Toast.LENGTH_SHORT)
                        .show()
                }.show()
        }

        binding.registerBtn.setOnClickListener {
            register()
        }
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun register() {
        val work = binding.etWork.text.toString()
        val phoneNumber = binding.edtPhoneNumber.text.toString()
        val fullName = binding.etFullName.text.toString()
        val password = binding.edtSeriaNumber.text.toString()
        val region = binding.textRegionChoose.text.toString()
        val login = binding.textDateChoose.text.toString()
        val bundle = Bundle()
        bundle.putString("password",password)
        bundle.putString("fullName",fullName)
        bundle.putString("work",work)
        bundle.putString("phoneNumber",phoneNumber)
        bundle.putString("region",region)
        bundle.putString("login",login)
        Log.d(TAG, "register: $login\n$region\n$password\n$fullName\n$work\n$phoneNumber")

        if (login.isNotBlank() && password.isNotBlank() && region.isNotBlank() && fullName.isNotBlank() && work.isNotBlank() && phoneNumber.isNotBlank()) {
            findNavController().navigate(R.id.action_registerFragment_to_mainPageFragment,bundle)
        }
    }

    private fun installRegion(item: String) {
        binding.textRegionChoose.text = item
        binding.textRegionChooseArrow.visibility = View.GONE

    }

    private fun updateLable(calendar: Calendar) {

        val format = "dd.MM.yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        binding.textDateChoose.text = sdf.format(calendar.time)
        binding.textDateChooseArrow.visibility = View.GONE
        binding.imageView3.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}