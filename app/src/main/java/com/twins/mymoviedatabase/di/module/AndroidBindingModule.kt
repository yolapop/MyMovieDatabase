package com.twins.mymoviedatabase.di.module

import com.twins.mymoviedatabase.HostActivity
import com.twins.mymoviedatabase.core.di.module.DatabaseModule
import com.twins.mymoviedatabase.core.di.scope.PerActivity
import com.twins.mymoviedatabase.feature.auth.AuthFragment
import com.twins.mymoviedatabase.feature.movie.MovieDetailFragment
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

    // region FRAGMENTS
    @ContributesAndroidInjector(modules = arrayOf(DatabaseModule::class))
    abstract fun authFragment(): AuthFragment

    @ContributesAndroidInjector(modules = arrayOf(DatabaseModule::class))
    abstract fun movieDetailFragment(): MovieDetailFragment
    // endregion

}