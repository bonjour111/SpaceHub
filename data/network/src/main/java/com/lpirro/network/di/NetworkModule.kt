package com.lpirro.network.di

import com.lpirro.network.BuildConfig
import com.lpirro.network.SpaceHubApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private fun getApiUrl() = buildString {
        append(BuildConfig.API_BASE_URL).append("/").append(BuildConfig.API_VERSION).append("/")
    }

    @Singleton
    @Provides
    fun provideRetrofit(): SpaceHubApiService = Retrofit.Builder()
        .baseUrl(getApiUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttp())
        .build()
        .create(SpaceHubApiService::class.java)

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun provideOkHttp(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(provideLoggingInterceptor())
        }

        return okHttpClient.build()
    }
}
