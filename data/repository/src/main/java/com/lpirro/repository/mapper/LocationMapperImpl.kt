package com.lpirro.repository.mapper

import com.lpirro.domain.models.Location
import com.lpirro.network.models.LocationRemote
import com.lpirro.persistence.model.LocationLocal

class LocationMapperImpl : LocationMapper {
    override fun mapToDomain(locationLocal: LocationLocal) = Location(
        id = locationLocal.id,
        name = locationLocal.name,
    )

    override fun mapToLocal(locationRemote: LocationRemote) = LocationLocal(
        id = locationRemote.id,
        name = locationRemote.name
    )
}
