package com.nagot.lootapp.utils

import android.content.Context
import android.net.ConnectivityManager

object ConnectionUtil {

    fun isInternetAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null &&
                connectivityManager.activeNetworkInfo.isConnected
    }
}