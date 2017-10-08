package com.twins.mymoviedatabase

import com.twins.mymoviedatabase.injection.component.DaggerApplicationComponent
import com.twins.mymoviedatabase.injection.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm

/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */
class MyMovieDatabaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Realm.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .create(this)
    }

    companion object {
        private lateinit var INSTANCE: MyMovieDatabaseApplication
        fun get(): MyMovieDatabaseApplication = INSTANCE
    }

}