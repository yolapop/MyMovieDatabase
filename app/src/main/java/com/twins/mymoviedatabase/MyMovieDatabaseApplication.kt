package com.twins.mymoviedatabase

import android.app.Application





/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */

public class MyMovieDatabaseApplication : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }


    override fun onCreate() {
        super.onCreate()
        component.inject(this)


//
//        // Configure Realm for the application
//        val realmConfiguration = RealmConfiguration.Builder(this)
//                .name("tasko.realm")
//                .build()
//        Realm.deleteRealm(realmConfiguration) // Clean slate
//        Realm.setDefaultConfiguration(realmConfiguration) // Make this Realm the default

    }

}