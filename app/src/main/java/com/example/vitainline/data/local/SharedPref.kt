package com.example.vitainline.data.local

import android.content.Context

private const val SHARED_PREF = "SHARED_PREF"
private const val SHARED_LANGUAGE = "SHARED_LANGUAGE"


class SharedPref(context: Context) : SharedPrefListener {

    private val sharedPrefListener = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    override fun getLang(): String {
        return sharedPrefListener.getString(SHARED_LANGUAGE, "") ?: ""
    }

    override fun saveLang(lang: String) {
        sharedPrefListener.edit().putString(SHARED_LANGUAGE, lang).apply()
    }
}