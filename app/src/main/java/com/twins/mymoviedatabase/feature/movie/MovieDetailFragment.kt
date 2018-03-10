package com.twins.mymoviedatabase.feature.movie

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import com.twins.mymoviedatabase.BaseFragment
import com.twins.mymoviedatabase.core.data.model.Movie
import com.twins.mymoviedatabase.core.netapi.NetworkState
import com.twins.mymoviedatabase.core.observer.reObserve

/**
 * Created by Yolanda-PC on 11/02/2018.
 */
class MovieDetailFragment : BaseFragment() {

    override var title: CharSequence? = "Movie Detail"

    private val viewModel by lazy { getViewModel(MovieDetailViewModel::class.java) }

    private val statusObserver: Observer<NetworkState> = Observer { Log.v("yolapop", it.toString()) }
    private val movieObserver: Observer<Movie> = Observer { Log.v("yolapop", it.toString()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.movieDetail.fetchData(123)
        }
        viewModel.movieDetail.status.reObserve(this, statusObserver)
        viewModel.movieDetail.data.reObserve(this, movieObserver)
    }

}