package com.twins.mymoviedatabase.core.data.dao

import com.twins.mymoviedatabase.core.data.model.Movie
import io.realm.Realm

/**
 * Created by bukalapak on 11/9/17.
 */
class RealmMovieRepository(private val realm: Realm) : MovieRepository {

    /**
     * This should be run on background thread
     */
    override fun add(movie: Movie) {
        realm.executeTransaction {
            // search genre berdasarkan genre_id
            // assign
            //realm.copyToRealm(movie)
        }
        /**
         * TODO:
         * > Use ViewModel and LiveData
         * > Inject Realm into ViewModel using ViewModelFactory
         */
    }

}