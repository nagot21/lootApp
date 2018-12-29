package com.nagot.lootapp.data.network.retrofit.services

import com.nagot.lootapp.data.network.retrofit.dto.User
import io.reactivex.Single
import retrofit2.http.GET

interface UsersApiService {

    @GET("users")
    fun getUsers(): Single<MutableList<User>>
}