package com.twins.mymoviedatabase.di.component

import com.twins.mymoviedatabase.App
import com.twins.mymoviedatabase.core.di.module.NetworkModule
import com.twins.mymoviedatabase.di.module.AndroidBindingModule
import com.twins.mymoviedatabase.di.module.ApplicationModule
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
        AndroidSupportInjectionModule::class,
        NetworkModule::class))
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun applicationModule(module: ApplicationModule): Builder
    }
}
