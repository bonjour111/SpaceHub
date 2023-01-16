package com.lpirro.repository.mapper

import com.lpirro.domain.models.Status
import com.lpirro.network.models.StatusRemote
import com.lpirro.persistence.model.StatusLocal

interface StatusMapper {
    fun mapToDomain(statusLocal: StatusLocal): Status

    fun mapToLocal(statusRemote: StatusRemote): StatusLocal
}
