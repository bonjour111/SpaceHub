package com.lpirro.domain.usecase

import com.lpirro.domain.models.Launch
import com.lpirro.domain.repository.LaunchesRepository
import kotlinx.coroutines.flow.Flow

class GetPastLaunchesUseCaseImpl(
    private val repository: LaunchesRepository
) : GetPastLaunchesUseCase {
    override suspend fun invoke(): Flow<List<Launch>> {
        return repository.getPastLaunches()
    }
}
