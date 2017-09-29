package com.twins.mymoviedatabase

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton




/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */

@Module class ApplicationModule(val application: Application) {
    @Provides @Singleton fun provideContext(): Context = application
    @Provides @Singleton fun provideSharedPreferences(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

}