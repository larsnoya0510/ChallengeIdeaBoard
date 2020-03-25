package com.example.challengeideaboard.api_network

import android.content.Context
import android.content.SharedPreferences

open class BaseSharePreference {

    companion object {

        private val PREFERENCE_FILE_NAME = "Token_Store"

        fun instance(context: Context): SharedPreferences {
            return context.applicationContext.getSharedPreferences(
                PREFERENCE_FILE_NAME,
                Context.MODE_PRIVATE
            )
        }

        fun putString(context: Context, value: String) {
            val editor = instance(context.applicationContext).edit()
            editor.putString("USER_TOKEN", value)
            editor.apply()
        }

        fun removeString(context: Context) {
            val editor = instance(context.applicationContext).edit()
            editor.remove("USER_TOKEN")
            editor.apply()
        }

        fun getString(context: Context): String {
            return instance(context.applicationContext).getString("USER_TOKEN", "")!!
        }
        //==user
        fun putUserString(context: Context, value: String) {
            val editor = instance(context.applicationContext).edit()
            editor.putString("USER", value)
            editor.apply()
        }

        fun removeUserString(context: Context) {
            val editor = instance(context.applicationContext).edit()
            editor.remove("USER")
            editor.apply()
        }

        fun getUserString(context: Context): String {
            return instance(context.applicationContext).getString("USER", "")!!
        }
    }
}