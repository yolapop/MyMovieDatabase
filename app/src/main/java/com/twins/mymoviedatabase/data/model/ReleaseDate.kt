package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by bukalapak on 11/8/17.
 */
/**
 * Complete release dates for a movie
 */
data class ReleaseDates(var results: Array<ReleaseDatesInCountry>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReleaseDates

        if (!Arrays.equals(results, other.results)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(results)
    }
}

/**
 * Collection of a movie's release dates in a Country
 */
data class ReleaseDatesInCountry(
        @SerializedName("iso_3166_1")
        var countryIso: String,
        @SerializedName("release_dates")
        var releaseDates: Array<ReleaseDate>? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReleaseDatesInCountry

        if (countryIso != other.countryIso) return false
        if (!Arrays.equals(releaseDates, other.releaseDates)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = countryIso.hashCode()
        result = 31 * result + (releaseDates?.let { Arrays.hashCode(it) } ?: 0)
        return result
    }
}

data class ReleaseDate(
        @SerializedName("iso_639_1")
        var languageIso: String? = null,
        var certification: String? = null,
        var note: String? = null,
        @SerializedName("release_date")
        var date: Date? = null,
        var type: Int? = null
)