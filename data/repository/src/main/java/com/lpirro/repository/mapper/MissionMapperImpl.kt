package com.lpirro.repository.mapper

import com.lpirro.domain.models.Mission
import com.lpirro.network.models.MissionRemote
import com.lpirro.persistence.model.MissionLocal

class MissionMapperImpl(private val orbitMapper: OrbitMapper) : MissionMapper {
    override fun mapToDomain(missionLocal: MissionLocal) = Mission(
        id = missionLocal.id,
        name = missionLocal.name,
        description = missionLocal.description,
        type = missionLocal.type,
        orbit = missionLocal.orbit?.let { orbitMapper.mapToDomain(it) }
    )

    override fun mapToLocal(missionRemote: MissionRemote) = MissionLocal(
        id = missionRemote.id,
        name = missionRemote.name,
        description = missionRemote.description,
        type = missionRemote.type,
        orbit = missionRemote.orbit?.let { orbitMapper.mapToLocal(it) }
    )
}
