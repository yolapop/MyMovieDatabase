package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by bukalapak on 11/5/17.
 */
data class Movie(
        var id: Long,
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
        var genres: Array<Genre>? = null,
        var homepage: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        var overview: String? = null,
        var popularity: Double? = null,
        @SerializedName("production_companies")
        var productionCompanies: Array<Company>? = null,
        @SerializedName("production_countries")
        var productionCountries: Array<Country>? = null,
        @SerializedName("release_date")
        var releaseDate: Date? = null,
        var revenue: Long? = null,
        var runtime: Long? = null,
        @SerializedName("spoken_languages")
        var spokenLanguage: Array<Language>? = null,
        var status: String? = null,
        var tagline: String? = null,
        var title: String? = null,
        var video: Boolean = false,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Long? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (imdbId != other.imdbId) return false
        if (adult != other.adult) return false
        if (backdropPath != other.backdropPath) return false
        if (posterPath != other.posterPath) return false
        if (belongsToCollection != other.belongsToCollection) return false
        if (budget != other.budget) return false
        if (!Arrays.equals(genres, other.genres)) return false
        if (homepage != other.homepage) return false
        if (originalLanguage != other.originalLanguage) return false
        if (originalTitle != other.originalTitle) return false
        if (overview != other.overview) return false
        if (popularity != other.popularity) return false
        if (!Arrays.equals(productionCompanies, other.productionCompanies)) return false
        if (!Arrays.equals(productionCountries, other.productionCountries)) return false
        if (releaseDate != other.releaseDate) return false
        if (revenue != other.revenue) return false
        if (runtime != other.runtime) return false
        if (!Arrays.equals(spokenLanguage, other.spokenLanguage)) return false
        if (status != other.status) return false
        if (tagline != other.tagline) return false
        if (title != other.title) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false
        if (voteCount != other.voteCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (imdbId?.hashCode() ?: 0)
        result = 31 * result + adult.hashCode()
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + (belongsToCollection?.hashCode() ?: 0)
        result = 31 * result + (budget?.hashCode() ?: 0)
        result = 31 * result + (genres?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + (homepage?.hashCode() ?: 0)
        result = 31 * result + (originalLanguage?.hashCode() ?: 0)
        result = 31 * result + (originalTitle?.hashCode() ?: 0)
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (popularity?.hashCode() ?: 0)
        result = 31 * result + (productionCompanies?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + (productionCountries?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + (releaseDate?.hashCode() ?: 0)
        result = 31 * result + (revenue?.hashCode() ?: 0)
        result = 31 * result + (runtime?.hashCode() ?: 0)
        result = 31 * result + (spokenLanguage?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (tagline?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + video.hashCode()
        result = 31 * result + (voteAverage?.hashCode() ?: 0)
        result = 31 * result + (voteCount?.hashCode() ?: 0)
        return result
    }

}