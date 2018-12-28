package com.nagot.lootapp.ui.base

import android.support.annotation.StringRes

/**
 *   Created by IanNagot on 28/12/2018
 */
interface MvpView {

    fun showToast(message: String?)

    fun showToast(@StringRes resId: Int)

    fun hideKeyboard()

    fun getBaseActivity(): BaseActivity
}