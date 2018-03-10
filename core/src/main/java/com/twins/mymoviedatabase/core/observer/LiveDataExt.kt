package com.twins.mymoviedatabase.core.observer

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

/**
 * Created by Yolanda-PC on 11/03/2018.
 */
fun <T> LiveData<T>.reObserve(owner: LifecycleOwner, observer: Observer<T>) {
    removeObserver(observer)
    observe(owner, observer)
}