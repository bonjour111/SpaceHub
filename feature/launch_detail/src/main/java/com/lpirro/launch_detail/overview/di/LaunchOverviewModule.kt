package com.lpirro.launch_detail.overview.di

import com.lpirro.launch_detail.overview.mapper.LaunchOverviewMapper
import com.lpirro.launch_detail.overview.mapper.LaunchOverviewMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LaunchOverviewModule {
    @Provides
    fun provideLaunchOverviewMapper(): LaunchOverviewMapper {
        return LaunchOverviewMapperImpl()
    }
}
