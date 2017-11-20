package com.twins.mymoviedatabase.catalog.injection.module

import com.twins.mymoviedatabase.ui.glide.ImageLoader
import com.twins.mymoviedatabase.ui.glide.ImageLoaderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by bukalapak on 11/21/17.
 */
@Module
object ImageModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideImageLoader(): ImageLoader = ImageLoaderImpl

}