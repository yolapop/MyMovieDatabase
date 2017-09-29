package com.twins.mymoviedatabase

import dagger.Component
import javax.inject.Singleton


/**
 * Created by Ridwan Arvihafiz on 9/29/17.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class ) )
interface ApplicationComponent {
    fun inject(target: MyMovieDatabaseApplication)
    fun inject(target: MainActivity)
}
