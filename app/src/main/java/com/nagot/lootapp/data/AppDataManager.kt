package com.nagot.lootapp.data

import com.nagot.lootapp.data.network.NetworkManager
import com.nagot.lootapp.data.network.retrofit.dto.User
import io.reactivex.Single

/**
 *   Created by IanNagot on 28/12/2018
 */
class AppDataManager(private val mNetworkManager: NetworkManager): DataManager {

    override fun getUsers(): Single<MutableList<User>> {
        return mNetworkManager.getUsers()
    }
}