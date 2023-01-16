package com.lpirro.network

import com.lpirro.network.models.LaunchRemote
import com.lpirro.network.models.PaginatedResultRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceHubApiService {

    @GET("launch/upcoming?mode=detailed&limit=20&hide_recent_previous=true")
    suspend fun getUpcomingLaunches(): PaginatedResultRemote<List<LaunchRemote>>

    @GET("launch/previous?mode=detailed&limit=20")
    suspend fun getPastLaunches(): PaginatedResultRemote<List<LaunchRemote>>

    @GET("launch/{id}")
    suspend fun getLaunch(@Path("id") id: String): LaunchRemote
}
