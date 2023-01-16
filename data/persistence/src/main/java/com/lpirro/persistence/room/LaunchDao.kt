package com.lpirro.persistence.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.lpirro.persistence.model.LaunchLocal
import com.lpirro.persistence.model.LaunchType

@Dao
interface LaunchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(launches: List<LaunchLocal>)

    @Update
    suspend fun updateLaunch(launch: LaunchLocal)

    @Query("SELECT * FROM launch_table WHERE type=:launchType")
    fun getLaunchesWithType(launchType: LaunchType): List<LaunchLocal>

    @Query("SELECT * FROM launch_table WHERE id=:id")
    fun getLaunch(id: String): LaunchLocal

    @Query("DELETE FROM launch_table WHERE type=:launchType")
    fun deleteAll(launchType: LaunchType)
}
