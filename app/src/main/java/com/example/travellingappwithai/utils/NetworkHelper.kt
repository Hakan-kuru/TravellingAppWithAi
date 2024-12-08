package com.example.travellingappwithai.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkHelper(private val context: Context) {
    fun isNetworkConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}
