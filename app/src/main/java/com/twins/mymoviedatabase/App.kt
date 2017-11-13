package com.twins.mymoviedatabase

//import com.twins.mymoviedatabase.core.injection.module.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm

/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        Realm.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        /*return DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .create(this)*/
        return null
    }

    companion object {
        private lateinit var INSTANCE: App
        fun get(): App = INSTANCE
    }

}