package com.lpirro.repository.mapper

import com.lpirro.domain.models.MapPosition

class MapPositionMapperImpl : MapPositionMapper {
    override fun mapToDomain(latitude: String?, longitude: String?): MapPosition? {
        if (latitude != null && longitude != null) {
            return MapPosition(latitude = latitude.toDouble(), longitude = longitude.toDouble())
        }
        return null
    }
}
