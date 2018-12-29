package com.nagot.lootapp.ui.main

import com.nagot.lootapp.data.network.retrofit.dto.UsersListResponse
import com.nagot.lootapp.ui.base.MvpView

interface MainViewInterface: MvpView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showNoConnection()

    fun hideNoConnection()

    fun loadUsersToAdapter(usersListResponse: UsersListResponse)
}