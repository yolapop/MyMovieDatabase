package com.twins.mymoviedatabase.feature_auth.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.twins.mymoviedatabase.BaseFragment
import com.twins.mymoviedatabase.R
import com.twins.mymoviedatabase.netapi.service.AuthenticationService
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_auth.*
import javax.inject.Inject

/**
 * Created by bukalapak on 10/29/17.
 */
class AuthFragment : BaseFragment() {

    @Inject
    lateinit var authService: Lazy<AuthenticationService>

    init {
        layoutRes = R.layout.fragment_auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAuth.setOnClickListener { doAuth() }
    }

    private fun doAuth() {
        Log.v("yolapop", "service " + authService.get())
    }

}