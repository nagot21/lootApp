package com.nagot.lootapp.ui.base

import android.support.annotation.StringRes

/**
 *   Created by IanNagot on 28/12/2018
 */
interface MvpView {

    fun showToast(message: String?)

    fun showToast(@StringRes resId: Int)

    fun showSnackbar(message: String?, viewResId: Int)

    fun showUndoSnackbar(itemName: String, viewResId: Int,
                         restoreItem: () -> Unit, deleteItem: () -> Unit)

    fun showSnackbar(@StringRes resId: Int)

    fun showSnackbar(@StringRes resId: Int, viewResId: Int)

    fun hideKeyboard()

    fun getBaseActivity(): BaseActivity
}