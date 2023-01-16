package com.lpirro.launch_detail.mission.mapper

import com.lpirro.domain.models.Launch
import com.lpirro.launch_detail.mission.model.LaunchMissionItem

interface LaunchMissionMapper {
    fun mapToUi(launch: Launch): List<LaunchMissionItem>
}
