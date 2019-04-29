package com.twins.mymoviedatabase.litho

import android.util.Log
import com.facebook.litho.EventHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingMoviesService(private val service: MovieService) {

    private var moviesEventHandler: EventHandler<MoviesEvent>? = null

    fun registerLoadingEvent(handler: EventHandler<MoviesEvent>) {
        moviesEventHandler = handler
    }

    fun unregisterLoadingEvent() {
        moviesEventHandler = null
    }

    fun fetch(page: Int) {
        Log.v("yolapop", "fetch $page")
        service.getUpcoming(page).enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.v("yolapop", "onFailure ")
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful) {
                    moviesEventHandler?.dispatchEvent(MoviesEvent().also {
                        it.movies = response.body()?.results?.toList() ?: emptyList()
                    })
                }
            }

        })
    }
}