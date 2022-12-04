package com.gads.crowdfunding.network.utility

import com.gads.crowdfunding.domain.DefaultResponse
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

fun <T> makeApiRequest(
    apiCall: () -> Call<T>,
    onSuccess: (T) -> Unit,
    onFailure: (DefaultResponse) -> Unit,
    onError: (Throwable) -> Unit
) {
    val retrofitCallback = object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody == null) {
                    onError(RuntimeException("No response body available"))
                    return
                }
                onSuccess(responseBody)
            } else {
                if (response.code() == 400 || response.code() == 403) {
                    if (!response.isSuccessful) {
                        val jsonObject: JSONObject?
                        try {
                            jsonObject = JSONObject(response.errorBody()!!.string())
                            val message: String = jsonObject.getString("message")
                            val success: Boolean = jsonObject.getBoolean("success")

                            return onFailure(DefaultResponse(success, message))

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                } else
                    return onError(HttpException(response))
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(t)
        }
    }

    apiCall().enqueue(retrofitCallback)
}