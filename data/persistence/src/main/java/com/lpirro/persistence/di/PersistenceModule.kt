package com.lpirro.persistence.di

import android.app.Application
import androidx.room.Room
import com.lpirro.persistence.room.LaunchDao
import com.lpirro.persistence.room.SpaceHubDatabase
import com.lpirro.persistence.room.typeconverter.AgencyLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.MissionLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.MissionPatchesLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.PadLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.StatusLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.UpdateLocalTypeConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(
        application: Application,
        agencyLocalTypeConverter: AgencyLocalTypeConverter,
        missionPatchesLocalTypeConverter: MissionPatchesLocalTypeConverter,
        padLocalTypeConverter: PadLocalTypeConverter,
        statusLocalTypeConverter: StatusLocalTypeConverter,
        missionLocalTypeConverter: MissionLocalTypeConverter,
        updateLocalTypeConverter: UpdateLocalTypeConverter
    ): SpaceHubDatabase {
        return Room
            .databaseBuilder(application, SpaceHubDatabase::class.java, "spacehub.db")
            .fallbackToDestructiveMigration()
            .addTypeConverter(agencyLocalTypeConverter)
            .addTypeConverter(missionPatchesLocalTypeConverter)
            .addTypeConverter(padLocalTypeConverter)
            .addTypeConverter(statusLocalTypeConverter)
            .addTypeConverter(missionLocalTypeConverter)
            .addTypeConverter(updateLocalTypeConverter)
            .build()
    }

    @Provides
    fun providesLaunchDao(database: SpaceHubDatabase): LaunchDao {
        return database.launchDao()
    }

    @Provides
    fun providesAgencyTypeConverter(): AgencyLocalTypeConverter {
        return AgencyLocalTypeConverter()
    }

    @Provides
    fun providesMissionPatchesTypeConverter(): MissionPatchesLocalTypeConverter {
        return MissionPatchesLocalTypeConverter()
    }

    @Provides
    fun providesPadTypeConverter(): PadLocalTypeConverter {
        return PadLocalTypeConverter()
    }

    @Provides
    fun provideStatusTypeConverter(): StatusLocalTypeConverter {
        return StatusLocalTypeConverter()
    }

    @Provides
    fun provideMissionLocalTypeConverter(): MissionLocalTypeConverter {
        return MissionLocalTypeConverter()
    }

    @Provides
    fun provideUpdateLocalTypeConverter(): UpdateLocalTypeConverter {
        return UpdateLocalTypeConverter()
    }
}
