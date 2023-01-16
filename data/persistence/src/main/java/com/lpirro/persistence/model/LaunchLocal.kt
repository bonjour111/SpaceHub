package com.lpirro.persistence.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launch_table")
data class LaunchLocal(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String?,
    @ColumnInfo(name = "launch_service_provider") val launchServiceProvider: AgencyLocal,
    @ColumnInfo(name = "mission_patches") val missionPatches: List<MissionPatchesLocal>?,
    @ColumnInfo(name = "pad") val pad: PadLocal,
    @ColumnInfo(name = "mission") val mission: MissionLocal?,
    @ColumnInfo(name = "net") val net: String?,
    @ColumnInfo(name = "window_start") val windowStart: String?,
    @ColumnInfo(name = "window_end") val windowEnd: String?,
    @ColumnInfo(name = "status") val status: StatusLocal,
    @ColumnInfo(name = "type") val type: LaunchType?,
    @ColumnInfo(name = "live_video_url") val liveVideoUrl: String?,
    @ColumnInfo(name = "info_url") val infoUrl: String?,
    @ColumnInfo(name = "flightclub_url") val flightClubUrl: String?,
    @ColumnInfo(name = "updates") val updates: List<UpdateLocal>?
)

enum class LaunchType {
    PAST,
    UPCOMING
}
