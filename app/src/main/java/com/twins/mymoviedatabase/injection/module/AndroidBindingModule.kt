package com.twins.mymoviedatabase.injection.module

import com.twins.mymoviedatabase.HostActivity
import com.twins.mymoviedatabase.auth.fragment.AuthFragment
import com.twins.mymoviedatabase.core.injection.module.DatabaseModule
import com.twins.mymoviedatabase.core.injection.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by bukalapak on 10/8/17.
 */
@Module
abstract class AndroidBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun hostActivity(): HostActivity

    @ContributesAndroidInjector(modules = arrayOf(DatabaseModule::class))
    abstract fun authFragment(): AuthFragment

}