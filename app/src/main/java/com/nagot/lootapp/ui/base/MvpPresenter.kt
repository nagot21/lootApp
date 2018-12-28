package com.nagot.lootapp.ui.base

/**
 *   Created by IanNagot on 28/12/2018
 */
interface MvpPresenter<V: MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()
}