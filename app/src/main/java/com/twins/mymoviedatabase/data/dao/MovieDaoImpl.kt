package com.twins.mymoviedatabase.data.dao

import com.twins.mymoviedatabase.data.model.Movie
import io.realm.Realm

/**
 * Created by bukalapak on 11/9/17.
 */
class MovieDaoImpl(private val realm: Realm) : MovieDao {

    /**
     * This should be run on background thread
     */
    override fun insert(movie: Movie) {
        realm.executeTransaction {
            realm.copyToRealm(movie)
        }
    }

}