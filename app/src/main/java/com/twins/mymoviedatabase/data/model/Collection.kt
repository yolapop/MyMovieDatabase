package com.twins.mymoviedatabase.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by bukalapak on 11/5/17.
 */
data class Collection(
        var id: Long,
        var name: String? = null,
        var overview: String? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        var parts: Array<Movie>? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Collection

        if (id != other.id) return false
        if (name != other.name) return false
        if (overview != other.overview) return false
        if (posterPath != other.posterPath) return false
        if (backdropPath != other.backdropPath) return false
        if (!Arrays.equals(parts, other.parts)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + (parts?.let { Arrays.hashCode(it) } ?: 0)
        return result
    }

}