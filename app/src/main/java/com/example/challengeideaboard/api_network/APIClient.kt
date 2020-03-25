package com.example.challengeideaboard.api_network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var BASE_URL:String="http://1aa6fcf9.ngrok.io"
    val getClient: ApiInterface
        get() {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
}

object APIResponseMessage{
    val onFailure="網路不穩定，請稍候"
}


