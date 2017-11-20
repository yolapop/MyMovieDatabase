package com.twins.mymoviedatabase.catalog

import com.twins.mymoviedatabase.catalog.injection.component.ApplicationComponent
import com.twins.mymoviedatabase.catalog.injection.component.DaggerApplicationComponent
import com.twins.mymoviedatabase.catalog.injection.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by bukalapak on 11/20/17.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .create(this)
        COMPONENT = component as ApplicationComponent
        return component
    }

    companion object {
        lateinit var INSTANCE: App
        lateinit var COMPONENT: ApplicationComponent
    }
}