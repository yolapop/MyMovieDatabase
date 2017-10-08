package com.twins.mymoviedatabase.injection.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.twins.mymoviedatabase.MyMovieDatabaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */
@Singleton
@Module
class ApplicationModule(private val application: MyMovieDatabaseApplication) {

    @Provides @Singleton
    fun provideContext(): Context = application

    @Provides @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

}