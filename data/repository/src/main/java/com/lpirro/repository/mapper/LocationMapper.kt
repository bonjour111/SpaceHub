package com.lpirro.repository.mapper

import com.lpirro.domain.models.Location
import com.lpirro.network.models.LocationRemote
import com.lpirro.persistence.model.LocationLocal

interface LocationMapper {
    fun mapToDomain(locationLocal: LocationLocal): Location
    fun mapToLocal(locationRemote: LocationRemote): LocationLocal
}
