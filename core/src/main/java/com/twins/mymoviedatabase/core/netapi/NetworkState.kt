package com.twins.mymoviedatabase.core.netapi

/**
 * Created by Yolanda-PC on 10/03/2018.
 */
sealed class NetworkState(val message: String? = null) {
    class Init : NetworkState()
    class Loading(message: String? = null) : NetworkState(message)
    class Success(message: String? = null) : NetworkState(message)
    class Error(message: String? = null) : NetworkState(message)
}