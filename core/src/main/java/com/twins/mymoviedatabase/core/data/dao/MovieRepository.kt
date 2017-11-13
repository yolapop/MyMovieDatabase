package com.twins.mymoviedatabase.core.data.dao

import com.twins.mymoviedatabase.core.data.model.Movie

/**
 * Created by bukalapak on 11/9/17.
 */
interface MovieRepository {
    fun add(movie: Movie)
}