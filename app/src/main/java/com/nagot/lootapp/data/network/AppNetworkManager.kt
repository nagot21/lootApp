package com.nagot.lootapp.data.network

import com.nagot.lootapp.data.network.retrofit.RetrofitInitializer
import com.nagot.lootapp.data.network.retrofit.dto.User
import io.reactivex.Single

/**
 *   Created by IanNagot on 28/12/2018
 */
class AppNetworkManager(private val mRetrofitInitializer: RetrofitInitializer): NetworkManager {

    override fun getUsers(): Single<MutableList<User>> {
        return mRetrofitInitializer.getUsersApiService().getUsers()
    }
}