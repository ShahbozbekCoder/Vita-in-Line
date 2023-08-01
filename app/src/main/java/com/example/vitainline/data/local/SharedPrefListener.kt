package com.example.vitainline.data.local

interface SharedPrefListener {

    fun getLang(): String

    fun saveLang(lang: String)

}