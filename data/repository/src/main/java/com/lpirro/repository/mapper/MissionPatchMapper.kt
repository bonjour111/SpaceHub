package com.lpirro.repository.mapper

import com.lpirro.domain.models.MissionPatches
import com.lpirro.network.models.MissionPatchesRemote
import com.lpirro.persistence.model.MissionPatchesLocal

interface MissionPatchMapper {
    fun mapToDomain(missionPatchesLocal: MissionPatchesLocal): MissionPatches

    fun mapToLocal(missionPatchesRemote: MissionPatchesRemote): MissionPatchesLocal
}
