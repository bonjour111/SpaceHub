package com.lpirro.domain.usecase

import com.lpirro.domain.models.Launch
import com.lpirro.domain.repository.LaunchesRepository
import kotlinx.coroutines.flow.Flow

class GetUpcomingLaunchesUseCaseImpl(
    private val repository: LaunchesRepository
) : GetUpcomingLaunchesUseCase {
    override suspend fun invoke(): Flow<List<Launch>> {
        return repository.getUpcomingLaunches()
    }
}
