package com.twins.mymoviedatabase.auth.fragment

import android.os.Bundle
import android.view.View
import com.twins.mymoviedatabase.BaseFragment
import com.twins.mymoviedatabase.R
import com.twins.mymoviedatabase.core.data.dao.RealmMovieRepository
import com.twins.mymoviedatabase.core.data.model.Collection
import com.twins.mymoviedatabase.core.data.model.Movie
import com.twins.mymoviedatabase.core.netapi.request.RequestToken
import com.twins.mymoviedatabase.core.netapi.result
import com.twins.mymoviedatabase.core.netapi.service.AuthenticationService
import com.twins.mymoviedatabase.core.util.toastShort
import io.realm.RealmList
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
        api.service(AuthenticationService::class.java)
                .createRequestToken(RequestToken("ksjhdf")).result { requestToken ->

        }

        val collection = Collection().apply {
            id = 1
            name = "Collection 1"
        }
        val movie = Movie().apply {
            id = 1
            title = "A Good Movie"
            belongsToCollection = collection
        }
        collection.movies = RealmList(movie)

        val dao = RealmMovieRepository(realm)
        dao.add(movie)
    }

}