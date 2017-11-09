package com.twins.mymoviedatabase.auth.fragment

import android.os.Bundle
import android.view.View
import com.twins.mymoviedatabase.BaseFragment
import com.twins.mymoviedatabase.R
import com.twins.mymoviedatabase.util.toastShort
import kotlinx.android.synthetic.main.fragment_auth.*

/**
 * Created by bukalapak on 10/29/17.
 */
class AuthFragment : BaseFragment() {

    init {
        layoutRes = R.layout.fragment_auth
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAuth.setOnClickListener { doAuth() }
    }

    private fun doAuth() {
        activity?.toastShort("api $api")
        /*api.service(AuthenticationService::class.java)
                .createRequestToken(RequestToken("ksjhdf")).result { requestToken ->  }*/
    }

}