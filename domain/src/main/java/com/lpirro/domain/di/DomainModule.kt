package com.lpirro.domain.di

import com.lpirro.domain.repository.LaunchDetailRepository
import com.lpirro.domain.repository.LaunchesRepository
import com.lpirro.domain.usecase.GetLaunchDetailOverviewUseCase
import com.lpirro.domain.usecase.GetLaunchDetailOverviewUseCaseImpl
import com.lpirro.domain.usecase.GetLaunchDetailUseCase
import com.lpirro.domain.usecase.GetLaunchDetailUseCaseImpl
import com.lpirro.domain.usecase.GetPastLaunchesUseCase
import com.lpirro.domain.usecase.GetPastLaunchesUseCaseImpl
import com.lpirro.domain.usecase.GetUpcomingLaunchesUseCase
import com.lpirro.domain.usecase.GetUpcomingLaunchesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetUpcomingLaunchesUseCase(repository: LaunchesRepository): GetUpcomingLaunchesUseCase {
        return GetUpcomingLaunchesUseCaseImpl(repository)
    }

    @Provides
    fun provideGetPastLaunchesUseCase(repository: LaunchesRepository): GetPastLaunchesUseCase {
        return GetPastLaunchesUseCaseImpl(repository)
    }

    @Provides
    fun provideGetLaunchDetailUseCase(repository: LaunchDetailRepository): GetLaunchDetailUseCase {
        return GetLaunchDetailUseCaseImpl(repository)
    }

    @Provides
    fun providesGetLaunchDetailOverviewUseCase(repository: LaunchDetailRepository): GetLaunchDetailOverviewUseCase {
        return GetLaunchDetailOverviewUseCaseImpl(repository)
    }
}
