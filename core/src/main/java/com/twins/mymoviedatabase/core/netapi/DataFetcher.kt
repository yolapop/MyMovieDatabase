package com.twins.mymoviedatabase.core.netapi

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.twins.mymoviedatabase.core.netapi.response.ApiResponse

/**
 * Created by Yolanda-PC on 11/03/2018.
 */
class DataFetcher<in A, B>(fetch: (param: A) -> LiveData<ApiResponse<B>>) {

    private val param = MutableLiveData<A>()
    private val fetcher: LiveData<ApiResponse<B>> = Transformations.switchMap(param) {
        status.value = NetworkState.Loading()
        fetch(it)
    }
    private val status = MutableLiveData<NetworkState>()
    private val data: LiveData<B> = Transformations.map(fetcher) { response ->
        status.value = if (response.success) NetworkState.Success(response.statusMessage) else
            NetworkState.Error(response.errorMessage)
        response.body
    }

    fun fetchData(param: A) {
        this.param.value = param
    }

    fun observeData(lifecycleOwner: LifecycleOwner, observer: Observer<B>) {
        data.observe(lifecycleOwner, observer)
    }

    fun observeStatus(lifecycleOwner: LifecycleOwner, observer: Observer<NetworkState>) {
        status.observe(lifecycleOwner, observer)
    }

}