package com.twins.mymoviedatabase.injection.component

/**
 * Created by bukalapak on 10/8/17.
 *
 * We do not need this if we are using [dagger.android.AndroidInjector]
 */
interface SubComponentBuilder<V> {
    fun <V> build(): V
}