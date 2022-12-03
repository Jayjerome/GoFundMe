package com.gads.crowdfunding.network.utility

import android.content.Context
import android.util.Log
import com.gads.crowdfunding.network.utility.NetworkUtils.isNetworkAvailable
import com.gads.crowdfunding.util.Constants.Companion.TAG
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkConnectionInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable(context)) {
            throw NoConnectionException()
        }
        val builder: Request.Builder = chain.request().newBuilder()
        Log.d(TAG, "intercept_: ${chain.request()}")
        return chain.proceed(builder.build())
    }

    inner class NoConnectionException : IOException() {
        override val message: String
            get() = super.message ?: "No Internet Connection"
    }
}