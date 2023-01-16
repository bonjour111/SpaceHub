package com.lpirro.repository.mapper

import com.lpirro.domain.models.Mission
import com.lpirro.network.models.MissionRemote
import com.lpirro.persistence.model.MissionLocal

interface MissionMapper {
    fun mapToDomain(missionLocal: MissionLocal): Mission
    fun mapToLocal(missionRemote: MissionRemote): MissionLocal
}
