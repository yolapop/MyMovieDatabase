package com.twins.mymoviedatabase.core.di.module

import com.twins.mymoviedatabase.core.config.TmdbConstants
import com.twins.mymoviedatabase.core.netapi.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by bukalapak on 10/26/17.
 */
@Module
object NetworkModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                    .header("Content-Type", "application/json;charset=utf-8")
                    .header("Authorization", "Bearer ${TmdbConstants.API_KEY_4}")
                    .method(original.method(), original.body())
                    .build()
            chain.proceed(request)
        }
        return builder.build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gsonFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(TmdbConstants.API_URL)
                .client(client)
                .addConverterFactory(gsonFactory)
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
    }

}