/*
 * SpaceHub - Designed and Developed by LPirro (Leonardo Pirro)
 * Copyright (C) 2023 Leonardo Pirro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.lpirro.network.di

import com.lpirro.network.BuildConfig
import com.lpirro.network.LaunchLibraryApiService
import com.lpirro.network.NewsApiService
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

    private fun getLaunchLibraryBaseUrl() = buildString {
        append(BuildConfig.LAUNCH_LIBRARY_BASE_URL).append("/")
        append(BuildConfig.LAUNCH_LIBRARY_API_VERSION).append("/")
    }

    private fun getSpaceFlightNewsBaseUrl() = buildString {
        append(BuildConfig.SPACEFLIGHT_NEWS_BASE_URL).append("/")
        append(BuildConfig.SPACEFLIGHT_NEWS_API_VERSION).append("/")
    }

    @Singleton
    @Provides
    fun provideLaunchLibraryApiService(): LaunchLibraryApiService = Retrofit.Builder()
        .baseUrl(getLaunchLibraryBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttp())
        .build()
        .create(LaunchLibraryApiService::class.java)

    @Singleton
    @Provides
    fun provideSpaceflightNewsApiService(): NewsApiService = Retrofit.Builder()
        .baseUrl(getSpaceFlightNewsBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttp())
        .build()
        .create(NewsApiService::class.java)

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
