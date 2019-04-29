package com.twins.mymoviedatabase.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.twins.mymoviedatabase.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */
@Module
class ApplicationModule(private val application: App) {

    @Provides @Singleton
    fun provideContext(): Context = application

    @Provides @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

}