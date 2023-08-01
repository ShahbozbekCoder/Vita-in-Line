package com.example.vitainline.data

import com.example.vitainline.data.local.SharedPrefListener
import javax.inject.Inject

class Repository @Inject constructor(private val sharedPrefListener: SharedPrefListener) {

    fun getLang() = sharedPrefListener.getLang()

    fun saveLang(lang: String) = sharedPrefListener.saveLang(lang)
}