package com.nagot.lootapp.data.network

import com.nagot.lootapp.data.network.retrofit.RetrofitInitializer
import com.nagot.lootapp.data.network.retrofit.dto.User
import io.reactivex.Single

/**
 *   Created by IanNagot on 28/12/2018
 */
class AppNetworkManager: NetworkManager {

    override fun getUsers(retrofitInitializer: RetrofitInitializer): Single<MutableList<User>> {
        return retrofitInitializer.getUsersApiService().getUsers()
    }
}