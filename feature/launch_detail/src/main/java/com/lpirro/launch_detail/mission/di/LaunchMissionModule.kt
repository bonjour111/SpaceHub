package com.lpirro.launch_detail.mission.di

import com.lpirro.launch_detail.mission.mapper.LaunchMissionMapper
import com.lpirro.launch_detail.mission.mapper.LaunchMissionMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LaunchMissionModule {
    @Provides
    fun provideLaunchMissionMapper(): LaunchMissionMapper {
        return LaunchMissionMapperImpl()
    }
}
