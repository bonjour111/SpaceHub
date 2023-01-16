package com.lpirro.repository.mapper

import com.lpirro.domain.models.Status
import com.lpirro.network.models.StatusRemote
import com.lpirro.persistence.model.StatusLocal

class StatusMapperImpl : StatusMapper {
    override fun mapToDomain(statusLocal: StatusLocal) = Status(
        id = statusLocal.id,
        name = statusLocal.name,
        abbrev = statusLocal.abbrev,
        description = statusLocal.description
    )

    override fun mapToLocal(statusRemote: StatusRemote) = StatusLocal(
        id = statusRemote.id,
        name = statusRemote.name,
        abbrev = statusRemote.abbrev,
        description = statusRemote.description
    )
}
