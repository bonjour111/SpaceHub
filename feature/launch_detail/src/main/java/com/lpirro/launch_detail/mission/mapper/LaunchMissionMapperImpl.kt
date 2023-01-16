package com.lpirro.launch_detail.mission.mapper

import com.lpirro.domain.models.Launch
import com.lpirro.domain.models.Mission
import com.lpirro.domain.models.Update
import com.lpirro.launch_detail.mission.model.DescriptionUi
import com.lpirro.launch_detail.mission.model.LaunchInfoUi
import com.lpirro.launch_detail.mission.model.LaunchMissionItem
import com.lpirro.launch_detail.mission.model.MissionDetailsUnavailableUi
import com.lpirro.launch_detail.mission.model.MissionHeaderUi
import com.lpirro.launch_detail.mission.model.UpdatesUi

class LaunchMissionMapperImpl : LaunchMissionMapper {

    override fun mapToUi(launch: Launch): List<LaunchMissionItem> {
        val launchMissionItems = mutableListOf<LaunchMissionItem>()

        launch.mission?.let { mission ->
            launchMissionItems.add(
                getMissionHeader(
                    mission,
                    launch.launchServiceProvider.name,
                    launch.missionPatches?.firstOrNull()?.imageUrl
                )
            )
            launchMissionItems.add(getMissionDescription(mission, launch.infoUrl))
            launchMissionItems.add(getLaunchInfoUi(launch))
            launch.updates?.let { launchMissionItems.add(getUpdatesUi(it)) }
        }

        if (launch.mission == null) {
            launchMissionItems.add(MissionDetailsUnavailableUi)
        }

        return launchMissionItems
    }

    private fun getMissionHeader(mission: Mission, agencyName: String, missionPatchUrl: String?) =
        MissionHeaderUi(
            name = mission.name,
            orbit = mission.orbit?.name ?: "N/A",
            agencyName = agencyName,
            missionType = mission.type,
            missionPatchUrl = missionPatchUrl
        )

    private fun getMissionDescription(mission: Mission, infoUrl: String?) = DescriptionUi(
        description = mission.description,
        infoUrl = infoUrl
    )

    private fun getLaunchInfoUi(launch: Launch) = LaunchInfoUi(
        status = launch.status.name,
        statusDescription = launch.status.description,
        net = launch.net ?: "N/A",
        windowStart = launch.windowStart ?: "N/A",
        windowEnd = launch.windowEnd ?: "N/A",
    )

    private fun getUpdatesUi(updates: List<Update>) = UpdatesUi(updates = updates)
}
