package com.example.vitainline.ui.fragments.signUp

import androidx.lifecycle.ViewModel
import com.example.vitainline.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun saveLang(lang: String) = repository.saveLang(lang)

    fun getLang() = repository.getLang()

}