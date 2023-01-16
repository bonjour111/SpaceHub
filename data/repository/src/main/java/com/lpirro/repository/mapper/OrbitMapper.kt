package com.lpirro.repository.mapper

import com.lpirro.domain.models.Orbit
import com.lpirro.network.models.OrbitRemote
import com.lpirro.persistence.model.OrbitLocal

interface OrbitMapper {
    fun mapToDomain(orbitLocal: OrbitLocal): Orbit
    fun mapToLocal(orbitRemote: OrbitRemote): OrbitLocal
}
