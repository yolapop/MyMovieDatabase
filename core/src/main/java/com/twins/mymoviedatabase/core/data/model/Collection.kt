package com.twins.mymoviedatabase.core.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by bukalapak on 11/5/17.
 */
open class Collection(
        @PrimaryKey var id: Long = 0,
        var name: String? = null,
        var overview: String? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("parts")
        var movies: RealmList<Movie>? = null
) : RealmObject()