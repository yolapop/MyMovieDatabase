package com.twins.mymoviedatabase.catalog.injection.component

import com.twins.mymoviedatabase.catalog.App
import com.twins.mymoviedatabase.catalog.injection.module.ApplicationModule
import com.twins.mymoviedatabase.catalog.injection.module.ImageModule
import com.twins.mymoviedatabase.ui.glide.ImageLoader
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by bukalapak on 11/20/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class,
        AndroidInjectionModule::class,
        ImageModule::class))
interface ApplicationComponent : AndroidInjector<App> {

    fun imageLoader(): ImageLoader

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun applicationModule(module: ApplicationModule): Builder
    }

}