/*
 *
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
 *
 */

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
