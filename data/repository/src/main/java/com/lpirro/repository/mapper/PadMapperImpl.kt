package com.lpirro.repository.mapper

import com.lpirro.domain.models.Pad
import com.lpirro.network.models.PadRemote
import com.lpirro.persistence.model.PadLocal

class PadMapperImpl(
    private val locationMapper: LocationMapper,
    private val mapPositionMapper: MapPositionMapper
) : PadMapper {
    override fun mapToDomain(padLocal: PadLocal) = Pad(
        id = padLocal.id,
        url = padLocal.url,
        agencyId = padLocal.agencyId,
        name = padLocal.name,
        infoUrl = padLocal.infoUrl,
        wikiUrl = padLocal.wikiUrl,
        mapUrl = padLocal.mapUrl,
        location = locationMapper.mapToDomain(padLocal.location),
        totalLaunchCount = padLocal.totalLaunchCount,
        orbitalLaunchAttemptCount = padLocal.orbitalLaunchAttemptCount,
        mapPosition = mapPositionMapper.mapToDomain(padLocal.latitude, padLocal.longitude)
    )

    override fun mapToLocal(padRemote: PadRemote) = PadLocal(
        id = padRemote.id,
        url = padRemote.url,
        agencyId = padRemote.agencyId,
        name = padRemote.name,
        infoUrl = padRemote.infoUrl,
        wikiUrl = padRemote.wikiUrl,
        mapUrl = padRemote.mapUrl,
        location = locationMapper.mapToLocal(padRemote.location),
        totalLaunchCount = padRemote.totalLaunchCount,
        orbitalLaunchAttemptCount = padRemote.orbitalLaunchAttemptCount,
        longitude = padRemote.longitude,
        latitude = padRemote.latitude
    )
}
