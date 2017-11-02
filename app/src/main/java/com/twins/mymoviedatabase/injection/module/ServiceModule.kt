package com.twins.mymoviedatabase.injection.module

import com.twins.mymoviedatabase.netapi.service.AuthenticationService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by bukalapak on 11/2/17.
 */
@Singleton
@Module
class ServiceModule {

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthenticationService {
        return retrofit.create(AuthenticationService::class.java)
    }

}