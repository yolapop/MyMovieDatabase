package com.twins.mymoviedatabase.core.data.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList

/**
 * Created by Yolanda-PC on 11/03/2018.
 */
class Configuration(
        var images: Images,
        @SerializedName("change_keys")
        var changeKeys: RealmList<String>? = null
) {

    class Images(
            @SerializedName("base_url")
            var baseUrl: String? = null,
            @SerializedName("secure_base_url")
            var secureBaseUrl: String? = null,
            @SerializedName("backdrop_sizes")
            var backdropSizes: RealmList<String>? = null,
            @SerializedName("logo_sizes")
            var logoSizes: RealmList<String>? = null,
            @SerializedName("poster_sizes")
            var posterSizes: RealmList<String>? = null,
            @SerializedName("profile_sizes")
            var profileSizes: RealmList<String>? = null,
            @SerializedName("still_sizes")
            var stillSizes: RealmList<String>? = null
    )

}