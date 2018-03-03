package com.twins.mymoviedatabase.core.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.twins.mymoviedatabase.core.netapi.Api
import javax.inject.Inject

/**
 * A factory to create [ViewModel]. A ViewModelFactory instance should only be associated with
 * an instance of Fragment/Activity. The ViewModel returned from here does not survive from
 * a completely destroyed Fragment/Activity. The ViewModel requested must be a subclass of
 * [BaseViewModel].
 */
class ViewModelFactory @Inject constructor(private val api: Api) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        try {
            return modelClass.getDeclaredConstructor(Api::class.java).newInstance(api)
        } catch (e : InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

        throw InstantiationException("Cannot create ViewModel")
    }

}