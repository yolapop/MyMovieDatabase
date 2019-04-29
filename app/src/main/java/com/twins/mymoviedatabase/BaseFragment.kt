package com.twins.mymoviedatabase

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (context as? Activity)?.title = title
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutRes?.let {
            inflater.inflate(it, container, false)
        } ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("created", true)
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun <M : ViewModel> getViewModel(klass : Class<M>): M {
        return ViewModelProviders.of(this, viewModelFactory)[klass]
    }

}