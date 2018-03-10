package com.twins.mymoviedatabase.core.netapi

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.twins.mymoviedatabase.core.netapi.response.ApiResponse

/**
 * Created by Yolanda-PC on 11/03/2018.
 */
class DataFetcher<in A, B>(fetch: (A) -> LiveData<ApiResponse<B>>) {

    private val param = MutableLiveData<A>()
    private val fetcher: LiveData<ApiResponse<B>> = Transformations.switchMap(param) {
        status.value = NetworkState.Loading()
        fetch(it)
    }
    val status = MutableLiveData<NetworkState>()
    val data: LiveData<B> = Transformations.map(fetcher) { response ->
        status.value = if (response.success) NetworkState.Success(response.statusMessage) else
            NetworkState.Error(response.errorMessage)
        response.body
    }

    fun fetchData(param: A) {
        this.param.value = param
    }

}