package com.lpirro.domain.repository

import com.lpirro.domain.models.Launch
import kotlinx.coroutines.flow.Flow

interface LaunchDetailRepository {
    suspend fun getLaunch(id: String): Flow<Launch>
}
