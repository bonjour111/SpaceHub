package com.lpirro.domain.usecase

import com.lpirro.domain.models.Launch
import kotlinx.coroutines.flow.Flow

interface GetUpcomingLaunchesUseCase {
    suspend operator fun invoke(): Flow<List<Launch>>
}
