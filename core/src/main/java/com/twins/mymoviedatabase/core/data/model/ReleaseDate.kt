package com.twins.mymoviedatabase.core.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by bukalapak on 11/8/17.
 */
/**
 * Complete release dates for a movie
 */
open class ReleaseDates(var results: RealmList<ReleaseDatesInCountry>? = null) : RealmObject()

/**
 * Collection of a movie's release dates in a Country
 */
open class ReleaseDatesInCountry(
        @PrimaryKey
        @SerializedName("iso_3166_1")
        var countryIso: String = "",
        @SerializedName("release_dates")
        var releaseDates: RealmList<ReleaseDate>? = null
) : RealmObject()

open class ReleaseDate(
        @PrimaryKey
        @SerializedName("iso_639_1")
        var languageIso: String = "",
        var certification: String? = null,
        var note: String? = null,
        @SerializedName("release_date")
        var date: Date? = null,
        var type: Int? = null
) : RealmObject()