package com.nagot.lootapp.ui.main

import com.nagot.lootapp.ui.base.MvpPresenter

interface MainPresenterInterface<V: MainViewInterface>: MvpPresenter<V> {

    fun getUserList()
}