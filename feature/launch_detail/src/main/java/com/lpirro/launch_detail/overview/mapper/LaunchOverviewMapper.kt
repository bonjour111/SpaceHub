package com.lpirro.launch_detail.overview.mapper

import com.lpirro.domain.models.Launch
import com.lpirro.launch_detail.overview.model.LaunchOverviewItem

interface LaunchOverviewMapper {
    fun mapToUi(launch: Launch): List<LaunchOverviewItem>
}
