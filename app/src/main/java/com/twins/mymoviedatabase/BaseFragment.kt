package com.twins.mymoviedatabase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twins.mymoviedatabase.netapi.Api
import dagger.android.DaggerFragment
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

    open var layoutRes: Int? = null
    open var title: CharSequence? = null
        set(value) {
            field = value
            if (isAdded) {
                activity?.title = value
            }
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

}