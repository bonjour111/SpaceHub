package com.lpirro.domain.repository

import com.lpirro.domain.models.Launch
import kotlinx.coroutines.flow.Flow

interface LaunchesRepository {
    suspend fun getUpcomingLaunches(): Flow<List<Launch>>
    suspend fun getPastLaunches(): Flow<List<Launch>>
}
