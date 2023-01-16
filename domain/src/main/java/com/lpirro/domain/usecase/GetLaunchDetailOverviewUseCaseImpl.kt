package com.lpirro.domain.usecase

import com.lpirro.domain.models.Launch
import com.lpirro.domain.repository.LaunchDetailRepository
import kotlinx.coroutines.flow.Flow

class GetLaunchDetailOverviewUseCaseImpl(
    private val repository: LaunchDetailRepository
) : GetLaunchDetailOverviewUseCase {
    override suspend fun invoke(id: String): Flow<Launch> {
        return repository.getLaunch(id)
    }
}
