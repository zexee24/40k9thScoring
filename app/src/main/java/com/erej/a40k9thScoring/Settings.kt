package com.erej.a40k9thScoring

import android.content.Context


class Settings(val context: Context) {

    private val settingFileName: String = "com.erej.40kScoring.settings"
    private val sharedPreferences = context.getSharedPreferences(settingFileName, Context.MODE_PRIVATE)

    fun writeSetting(setting: String, value: String){
        with(sharedPreferences.edit()){
            putString(setting, value)
            apply()
        }
    }

    fun writeSetting(setting: String, value: Boolean){
        with(sharedPreferences.edit()){
            putBoolean(setting, value)
            apply()
        }
    }

    fun getSetting(setting : String) : String?{
        return sharedPreferences.getString(setting, "")
    }

    fun getSettingBool(setting : String) : Boolean?{
        return sharedPreferences.getBoolean(setting, false)
    }
}