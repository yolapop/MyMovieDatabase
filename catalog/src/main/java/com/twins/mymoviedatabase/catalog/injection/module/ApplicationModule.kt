package com.twins.mymoviedatabase.catalog.injection.module

import android.content.Context
import com.twins.mymoviedatabase.catalog.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by bukalapak on 11/20/17.
 */
@Singleton
@Module
class ApplicationModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

}