package com.twins.mymoviedatabase.feature.movie

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.twins.mymoviedatabase.BaseFragment
import com.twins.mymoviedatabase.litho.Movie
import com.twins.mymoviedatabase.litho.MovieCardOne
import com.twins.mymoviedatabase.util.dp

/**
 * Created by Yolanda-PC on 11/02/2018.
 */
class MovieDetailFragment : BaseFragment() {

    override var title: CharSequence? = "Movie Detail"

    private val viewModel by lazy { getViewModel(MovieDetailViewModel::class.java) }

    /*private val statusObserver: Observer<NetworkState> = Observer { Log.v("yolapop", it.toString()) }
    private val movieObserver: Observer<Movie> = Observer { Log.v("yolapop", it.toString()) }*/

    private val dummyMovie = Movie(id = 123,
            title = "The Lord of the Rings",
            posterPath = "/1l3WpoF7TX9pOprX4XepCXjQXUV.jpg",
            runtime = 132,
            voteAverage = 6.5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.movieDetail.fetchData(123)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val component = MovieCardOne.create(ComponentContext(context))
                .movie(dummyMovie)
                .build()
        val layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).also {
            it.gravity = Gravity.CENTER
            val dp24 = 24.dp.toInt()
            it.setMargins(dp24, dp24, dp24, dp24)
        }
        return LithoView.create(ComponentContext(context), component).also {
            it.layoutParams = layoutParams
        }
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movieDetail.observeStatus(viewLifecycleOwner, statusObserver)
        viewModel.movieDetail.observeData(viewLifecycleOwner, movieObserver)
    }*/

}