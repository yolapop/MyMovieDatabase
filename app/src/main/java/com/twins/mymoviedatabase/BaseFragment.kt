package com.twins.mymoviedatabase

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twins.mymoviedatabase.core.netapi.Api
import com.twins.mymoviedatabase.core.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import io.realm.Realm
import javax.inject.Inject

/**
 * Created by bukalapak on 10/29/17.
 */
open class BaseFragment : DaggerFragment() {
    @Inject
    lateinit var api: Api
    @Inject
    lateinit var realm: Realm
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    open var layoutRes: Int? = null
    open var title: CharSequence? = null
        set(value) {
            field = value
            if (isAdded) {
                activity?.title = value
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutRes?.let {
            inflater.inflate(it, container, false)
        } ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    /**
     * Call data observers in here. This method will be called in [onCreate].
     */
    open fun observeData() {}

    fun <M : ViewModel> getViewModel(klass : Class<M>): M {
        return ViewModelProviders.of(this, viewModelFactory)[klass]
    }

}