package com.nagot.lootapp.ui.main

import com.nagot.lootapp.data.network.retrofit.dto.User
import com.nagot.lootapp.ui.base.MvpView

interface MainViewInterface: MvpView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showNoConnection()

    fun hideNoConnection()

    fun loadUsersToAdapter(userList: MutableList<User>)

    fun showErrorMessage()
}