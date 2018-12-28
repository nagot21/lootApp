package com.nagot.lootapp.ui.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *   Created by IanNagot on 28/12/2018
 */
abstract class BaseFragment: Fragment(), MvpView {

    private lateinit var mActivity: BaseActivity

    /** Activate back when adding Dagger 2*/
//    private lateinit var activityComponent: ActivityComponent

    /** Activate back when adding Dagger 2*/

   /* fun getActivityComponent(): ActivityComponent {
        return activityComponent
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getFragmentLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.mActivity = context
            mActivity.onFragmentAttached()

            /** Activate back when adding Dagger 2*/

            /*activityComponent = DaggerActivityComponent.builder()
                    .activityModule(ActivityModule(getBaseActivity(), this))
                    .applicationComponent((context.applicationContext as SimpleEvCalcApp).getApplicationComponent())
                    .build()*/
        }
    }

    override fun showToast(message: String?) {
        mActivity.showToast(message)
    }

    override fun showToast(resId: Int) {
        mActivity.showToast(resId)
    }

    override fun showSnackbar(message: String?, viewResId: Int) {
        mActivity.showSnackbar(message, viewResId)
    }

    override fun showSnackbar(resId: Int, viewResId: Int) {
        mActivity.showSnackbar(getString(resId), viewResId)
    }

    override fun showSnackbar(resId: Int) {
        mActivity.showSnackbar(getString(resId), -1)
    }

    override fun showUndoSnackbar(itemName: String, viewResId: Int,
                                  restoreItem: () -> Unit, deleteItem: () -> Unit) {
        mActivity.showUndoSnackbar(itemName, viewResId, restoreItem, deleteItem)
    }

    override fun hideKeyboard() {
        mActivity.hideKeyboard()
    }

    protected abstract fun setUp(view: View?)

    protected abstract fun getFragmentLayout(): Int

    override fun getBaseActivity(): BaseActivity = mActivity

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String? = null, itemId: Long? = null, backPressed: Boolean = true)

        fun onReplaceFragment(originClassTag: String, destClassTag: String,
                              item: Any? = null) /** Replace item: Any? with an object of your choice */

    }
}