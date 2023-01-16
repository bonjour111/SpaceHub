package com.lpirro.launch_detail.mission.model

import com.lpirro.domain.models.Update

interface LaunchMissionItem

data class MissionHeaderUi(
    val name: String,
    val orbit: String,
    val agencyName: String,
    val missionType: String,
    val missionPatchUrl: String?
) : LaunchMissionItem

data class DescriptionUi(
    val description: String,
    val infoUrl: String?
) : LaunchMissionItem

data class LaunchInfoUi(
    val status: String,
    val statusDescription: String,
    val net: String,
    val windowStart: String,
    val windowEnd: String
) : LaunchMissionItem

data class UpdatesUi(
    val updates: List<Update>
) : LaunchMissionItem

object MissionDetailsUnavailableUi : LaunchMissionItem
