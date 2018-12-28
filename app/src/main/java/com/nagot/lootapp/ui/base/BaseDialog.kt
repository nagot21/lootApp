package com.nagot.lootapp.ui.base

import android.app.Dialog
import android.app.DialogFragment
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout

/**
 *   Created by IanNagot on 28/12/2018
 */
abstract class BaseDialog: DialogFragment(), DialogMvpView {

    private lateinit var mActivity: BaseActivity

    /** Activate back when adding Dagger 2*/
//    private lateinit var activityComponent: ActivityComponent

    /** Activate back when adding Dagger 2*/

   /* fun getActivityComponent(): ActivityComponent {
        return activityComponent
    }*/

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        /* Content part */

        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        /* Create the fullscreen dialog */

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(root)

        if (dialog.window != null){
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
        }

        dialog.setCanceledOnTouchOutside(false)

        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getDialogLayout(), container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun dismissDialog(tag: String) {
        dismiss()
        getBaseActivity().onFragmentDetached(tag)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            this.mActivity = context
            this.mActivity.onFragmentAttached()

            /** Activate back when adding Dagger 2*/

            /*activityComponent = DaggerActivityComponent.builder()
                    .activityModule(ActivityModule(getBaseActivity()))
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

    override fun getBaseActivity(): BaseActivity = mActivity

    protected abstract fun setUp(view: View?)

    protected abstract fun getDialogLayout(): Int
}