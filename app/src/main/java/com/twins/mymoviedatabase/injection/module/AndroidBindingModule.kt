package com.twins.mymoviedatabase.injection.module

import com.twins.mymoviedatabase.MainActivity
import com.twins.mymoviedatabase.injection.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by bukalapak on 10/8/17.
 */
@Module
abstract class AndroidBindingModule {
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(DatabaseModule::class))
    abstract fun mainActivity(): MainActivity
}