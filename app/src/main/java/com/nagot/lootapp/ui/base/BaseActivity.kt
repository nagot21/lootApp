package com.nagot.lootapp.ui.base

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.nagot.lootapp.R
import com.nagot.lootapp.utils.KeyboardUtils

/**
 *   Created by IanNagot on 28/12/2018
 */
abstract class BaseActivity: AppCompatActivity(), MvpView, BaseFragment.Callback {

    /** Activate back when adding Dagger 2*/
    //private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Activate back when adding Dagger 2*/

        /*activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((applicationContext as ApplicationClass).getApplicationComponent())
                .build()*/

        setContentView(getActivityLayout())

        setUp()
    }

    /** Activate back when adding Dagger 2*/

    /*fun getActivityComponent(): ActivityComponent {
        return activityComponent
    }*/

    fun getActionToolbar() = supportActionBar

    fun addFragmentOnTop(fragment: BaseFragment, fragmentTag: String,
                         actionBarDrawerToggle: ActionBarDrawerToggle? = null) {

            /*supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.activityFrameLayout, fragment, fragmentTag) /** Change R.id.activityFrameLayout with you FrameLayout Id*/
                    .addToBackStack(fragmentTag)
                    .commit()*/
    }

    fun removeFragmentOnTop(tag: String?) {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(tag)

        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow()
        }

        fragmentManager.popBackStack()
    }

    override fun showToast(message: String?) {
        val toast = Toast.makeText(this, message ?: getText(R.string.error_occurred),
                Toast.LENGTH_LONG)

        val toastLayout = toast.view as LinearLayout

        if (toastLayout.childCount > 0) {
            val toastText = toastLayout.getChildAt(0) as TextView
            toastText.gravity = Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
        }

        toast.show()
    }

    override fun showToast(resId: Int) {
        showToast(getString(resId))
    }

    override fun showSnackbar(message: String?, viewResId: Int) {
        val snackBar = Snackbar.make(
                findViewById(if (viewResId == -1) {
                    android.R.id.content
                } else {
                    viewResId
                }), message ?: getText(R.string.error_occurred), Snackbar.LENGTH_LONG)
        snackBar.show()
    }

    override fun showSnackbar(resId: Int, viewResId: Int) {
        showSnackbar(getString(resId), viewResId)
    }

    override fun showSnackbar(resId: Int) {
        showSnackbar(getString(resId), -1)
    }

    override fun showUndoSnackbar(itemName: String, viewResId: Int,
                                  restoreItem: () -> Unit, deleteItem: () -> Unit) {

        val snackBar = Snackbar.make(findViewById(viewResId),
                getString(R.string.item_deleted,
                        itemName), Snackbar.LENGTH_LONG)

        snackBar.setAction(getString(R.string.undo).capitalize()) { restoreItem() }
        snackBar.setActionTextColor(Color.YELLOW)

        snackBar.addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                if (event != Snackbar.Callback.DISMISS_EVENT_ACTION) {
                    deleteItem()
                }
            }
        })
        snackBar.show()
    }

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(this)
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String?, itemId: Long?, backPressed: Boolean) {

    }

    override fun onReplaceFragment(originClassTag: String, destClassTag: String,
                                   item: Any?) {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0,0)
    }

    override fun getBaseActivity(): BaseActivity = this

    protected abstract fun setUp()

    protected abstract fun getActivityLayout(): Int
}