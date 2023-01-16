package com.lpirro.repository.mapper

import com.lpirro.domain.models.MapPosition

interface MapPositionMapper {
    fun mapToDomain(latitude: String?, longitude: String?): MapPosition?
}
