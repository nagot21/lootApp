package com.nagot.lootapp.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.nagot.lootapp.LootApplication
import com.nagot.lootapp.R
import com.nagot.lootapp.di.components.ActivityComponent
import com.nagot.lootapp.di.components.DaggerActivityComponent
import com.nagot.lootapp.di.modules.ActivityModule
import com.nagot.lootapp.utils.KeyboardUtils

/**
 *   Created by IanNagot on 28/12/2018
 */
abstract class BaseActivity: AppCompatActivity(), MvpView {

    /** Activate back when adding Dagger 2*/
    private lateinit var mActivityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((applicationContext as LootApplication)
                        .getApplicationComponent())
                .build()

        setContentView(getActivityLayout())

        setUp()
    }

    fun getActivityComponent(): ActivityComponent {
        return mActivityComponent
    }

    fun getActionToolbar() = supportActionBar

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

    override fun hideKeyboard() {
        KeyboardUtils.hideSoftInput(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(0,0)
    }

    override fun getBaseActivity(): BaseActivity = this

    protected abstract fun setUp()

    protected abstract fun getActivityLayout(): Int
}