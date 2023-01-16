package com.lpirro.persistence.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lpirro.persistence.model.LaunchLocal
import com.lpirro.persistence.room.typeconverter.AgencyLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.MissionLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.MissionPatchesLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.PadLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.StatusLocalTypeConverter
import com.lpirro.persistence.room.typeconverter.UpdateLocalTypeConverter

@Database(entities = [LaunchLocal::class], version = 1, exportSchema = true)
@TypeConverters(value = [AgencyLocalTypeConverter::class, MissionPatchesLocalTypeConverter::class, PadLocalTypeConverter::class, StatusLocalTypeConverter::class, MissionLocalTypeConverter::class, UpdateLocalTypeConverter::class])
abstract class SpaceHubDatabase : RoomDatabase() {
    abstract fun launchDao(): LaunchDao
}
