package com.nagot.lootapp.data.network.retrofit

import com.nagot.lootapp.data.network.retrofit.services.UsersApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val mRetrofit: Retrofit
    private val mBaseUrl = "https://jsonplaceholder.typicode.com/"

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)

        mRetrofit = Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build()
    }

    fun getUsersApiService(): UsersApiService {
        return mRetrofit.create(UsersApiService::class.java)
    }
}