package com.example.challengeideaboard.api_network

import android.content.Context

class SharePreferenceUtil : BaseSharePreference() {

    companion object {

        internal var token = "" //不希望頻繁的存取硬體，存在記憶體中
        internal var user = "" //不希望頻繁的存取硬體，存在記憶體中
        internal var pushToken = "" //不希望頻繁的存取硬體，存在記憶體中
        fun saveToken(context: Context, token: String) {
            putString(context, token)
            Companion.token = token
        }

        fun getUserToken(context: Context): String {
            token = getString(context)
            return token
        }

        fun removeToken(context: Context) {
            return removeString(context)
        }
        //
        fun saveUser(context: Context, user: String) {
            putUserString(context, user)
            Companion.user = user
        }

        fun getUser(context: Context): String {
            user = getUserString(context)
            return user
        }

        fun removeUser(context: Context) {
            return removeUserString(context)
        }
    }
}