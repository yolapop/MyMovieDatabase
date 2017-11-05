package com.twins.mymoviedatabase.netapi

import com.twins.mymoviedatabase.netapi.response.BaseResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by bukalapak on 11/4/17.
 */
@Singleton
class Api @Inject constructor(private val retrofit: Retrofit) {
    private val serviceCache = mutableMapOf<String, Any>()

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> service(klass: Class<T>): T {
        val klassName = klass.canonicalName
        return (serviceCache[klassName] as? T) ?: let {
            val s = retrofit.create(klass)
            serviceCache[klassName] = s
            s
        }
    }
}

inline fun <T : BaseResponse> Call<T>.result(crossinline result: (T?) -> Unit) {
    Single.fromCallable {
        val response = this@result.execute()
        val body = response.body()
        body
    }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { result.invoke(it) }
            .doOnError { result.invoke(null) }
}