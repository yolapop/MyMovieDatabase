package com.twins.mymoviedatabase.litho

/*import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey*/
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Created by bukalapak on 11/5/17.
 */
class Movie(
        var id: Long = 0,
        @SerializedName("imdb_id")
        var imdbId: String? = null,
        var adult: Boolean = false,
        @SerializedName("backdrop_path")
        var backdropPath: String? = null,
        @SerializedName("poster_path")
        var posterPath: String? = null,
        var budget: Long? = null,
        @SerializedName("genre_ids")
        var genreIds: List<Long>? = null,
        var homepage: String? = null,
        @SerializedName("original_language")
        var originalLanguage: String? = null,
        @SerializedName("original_title")
        var originalTitle: String? = null,
        var overview: String? = null,
        var popularity: Double? = null,
        var revenue: Long? = null,
        var runtime: Long? = null,
        var status: String? = null,
        var tagline: String? = null,
        var title: String? = null,
        var video: Boolean = false,
        @SerializedName("vote_average")
        var voteAverage: Double? = null,
        @SerializedName("vote_count")
        var voteCount: Long? = null,
        @SerializedName("release_date")
        var releaseDate: Date? = null
) {

}