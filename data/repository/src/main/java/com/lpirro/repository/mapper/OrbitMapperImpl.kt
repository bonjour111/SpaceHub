package com.lpirro.repository.mapper

import com.lpirro.domain.models.Orbit
import com.lpirro.network.models.OrbitRemote
import com.lpirro.persistence.model.OrbitLocal

class OrbitMapperImpl : OrbitMapper {
    override fun mapToDomain(orbitLocal: OrbitLocal) = Orbit(
        id = orbitLocal.id,
        name = orbitLocal.name,
        abbrev = orbitLocal.abbrev
    )

    override fun mapToLocal(orbitRemote: OrbitRemote) = OrbitLocal(
        id = orbitRemote.id,
        name = orbitRemote.name,
        abbrev = orbitRemote.abbrev
    )
}
