package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Ignore
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by bukalapak on 11/5/17.
 */
open class Movie(
        @PrimaryKey var id: Long = 0,
        @SerializedName("imdb_id")
        var imdbId: String? = null,
        var adult: Boolean = false,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("belongs_to_collection")
        var belongsToCollection: Collection? = null,
        var budget: Long? = null,
        var genres: RealmList<Genre>? = null,
        var homepage: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        var overview: String? = null,
        var popularity: Double? = null,
        @SerializedName("production_companies")
        var productionCompanies: RealmList<Company>? = null,
        @SerializedName("production_countries")
        var productionCountries: RealmList<Country>? = null,
        var revenue: Long? = null,
        var runtime: Long? = null,
        @SerializedName("spoken_languages")
        var spokenLanguage: RealmList<Language>? = null,
        var status: String? = null,
        var tagline: String? = null,
        var title: String? = null,
        var video: Boolean = false,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Long? = null,
        @SerializedName("release_date")
        var releaseDate: Date? = null,
        /**
         * This is only for JSON structure, for real stuff, you should use [releaseDates]
         */
        @Ignore
        @SerializedName("release_dates")
        var gsonReleaseDates: ReleaseDates? = null,
        @Transient
        var releaseDates: RealmList<ReleaseDatesInCountry>? = null
) : RealmObject()