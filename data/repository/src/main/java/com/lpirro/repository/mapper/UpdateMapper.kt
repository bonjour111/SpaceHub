package com.lpirro.repository.mapper

import com.lpirro.domain.models.Update
import com.lpirro.network.models.UpdateRemote
import com.lpirro.persistence.model.UpdateLocal

interface UpdateMapper {
    fun mapToDomain(updateLocal: UpdateLocal): Update
    fun mapToLocal(updateRemote: UpdateRemote): UpdateLocal
}
