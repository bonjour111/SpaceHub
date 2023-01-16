package com.lpirro.repository.mapper

import com.lpirro.domain.models.MissionPatches
import com.lpirro.network.models.MissionPatchesRemote
import com.lpirro.persistence.model.MissionPatchesLocal

class MissionPatchesMapperImpl : MissionPatchMapper {
    override fun mapToDomain(missionPatchesLocal: MissionPatchesLocal) = MissionPatches(
        id = missionPatchesLocal.id,
        name = missionPatchesLocal.name,
        imageUrl = missionPatchesLocal.imageUrl
    )

    override fun mapToLocal(missionPatchesRemote: MissionPatchesRemote) = MissionPatchesLocal(
        id = missionPatchesRemote.id,
        name = missionPatchesRemote.name,
        imageUrl = missionPatchesRemote.imageUrl
    )
}
