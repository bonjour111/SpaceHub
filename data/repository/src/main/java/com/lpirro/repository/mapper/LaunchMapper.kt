package com.lpirro.repository.mapper

import com.lpirro.domain.models.Launch
import com.lpirro.network.models.LaunchRemote
import com.lpirro.persistence.model.LaunchLocal
import com.lpirro.persistence.model.LaunchType

interface LaunchMapper {
    fun mapToDomain(launchLocal: LaunchLocal): Launch

    fun mapToLocal(launchRemote: LaunchRemote, launchType: LaunchType?): LaunchLocal
}
