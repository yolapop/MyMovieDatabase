package com.twins.mymoviedatabase.core.netapi.response

import com.google.gson.annotations.SerializedName
import com.twins.mymoviedatabase.core.data.model.Movie
import java.util.*

/**
 * Created by bukalapak on 11/9/17.
 */
data class NowPlaying(
        var page: Long,
        var results: Array<Movie>? = null,
        var dates: Dates? = null,
        @SerializedName("total_pages")
        var totalPages: Long? = 0,
        @SerializedName("total_results")
        var totalResults: Long? = 0
) : BaseResponse() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NowPlaying

        if (page != other.page) return false
        if (!Arrays.equals(results, other.results)) return false
        if (dates != other.dates) return false
        if (totalPages != other.totalPages) return false
        if (totalResults != other.totalResults) return false

        return true
    }

    override fun hashCode(): Int {
        var result = page.hashCode()
        result = 31 * result + (results?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + (dates?.hashCode() ?: 0)
        result = 31 * result + (totalPages?.hashCode() ?: 0)
        result = 31 * result + (totalResults?.hashCode() ?: 0)
        return result
    }
}