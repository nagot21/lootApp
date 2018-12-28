package com.nagot.lootapp

import android.app.Application
import android.util.Log
import com.nagot.lootapp.di.components.ApplicationComponent
import com.nagot.lootapp.di.components.DaggerApplicationComponent
import com.nagot.lootapp.di.modules.ApplicationModule

class LootApplication : Application() {

    private lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        initializeDaggerComponents()

        logScreenMetrics()
    }

    fun getApplicationComponent() = mApplicationComponent

    private fun initializeDaggerComponents() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(applicationContext))
                .build()

        mApplicationComponent.inject(this)
    }

    private fun logScreenMetrics() {
        val density = resources.displayMetrics.density

        val smallestWidthDp = resources.configuration.smallestScreenWidthDp

        val height = resources.configuration.screenHeightDp

        Log.i("density", "SmallestWidthDp: $smallestWidthDp, Height: $height, " +
                "Density: $density")
    }
}