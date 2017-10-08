package com.twins.mymoviedatabase.injection.component

import com.twins.mymoviedatabase.MyMovieDatabaseApplication
import com.twins.mymoviedatabase.injection.module.AndroidBindingModule
import com.twins.mymoviedatabase.injection.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class,
        AndroidBindingModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent : AndroidInjector<MyMovieDatabaseApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyMovieDatabaseApplication>() {
        abstract fun applicationModule(module: ApplicationModule): Builder
    }
}
