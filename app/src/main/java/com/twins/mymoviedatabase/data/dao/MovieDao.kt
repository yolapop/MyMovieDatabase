package com.twins.mymoviedatabase.data.dao

import com.twins.mymoviedatabase.data.model.Movie

/**
 * Created by bukalapak on 11/9/17.
 */
interface MovieDao {
    fun insert(movie: Movie)
}