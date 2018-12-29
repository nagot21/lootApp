package com.nagot.lootapp.data.network.retrofit

import com.nagot.lootapp.data.network.retrofit.services.UsersApiService
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

    private val mRetrofit: Retrofit
    private val mBaseUrl = "https://jsonplaceholder.typicode.com/"

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(1, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .readTimeout(1, TimeUnit.SECONDS)
                .connectionPool(ConnectionPool(0,
                        1, TimeUnit.NANOSECONDS))

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