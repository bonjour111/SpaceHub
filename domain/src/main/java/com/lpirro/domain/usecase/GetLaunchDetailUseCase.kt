package com.lpirro.domain.usecase

import com.lpirro.domain.models.Launch
import kotlinx.coroutines.flow.Flow

interface GetLaunchDetailUseCase {
    suspend operator fun invoke(id: String): Flow<Launch>
}
