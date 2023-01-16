package com.lpirro.repository.mapper

import com.lpirro.domain.models.Agency
import com.lpirro.network.models.AgencyRemote
import com.lpirro.persistence.model.AgencyLocal

class AgencyMapperImpl : AgencyMapper {
    override fun mapToDomain(agencyLocal: AgencyLocal) = Agency(
        id = agencyLocal.id,
        url = agencyLocal.url,
        name = agencyLocal.name,
        countryCode = agencyLocal.countryCode,
        administrator = agencyLocal.administrator ?: "N/A",
        foundingYear = agencyLocal.foundingYear ?: "N/A",
        totalLaunchCount = agencyLocal.totalLaunchCount?.toString() ?: "N/A",
        logoUrl = agencyLocal.logoUrl
    )

    override fun mapToLocal(agencyRemote: AgencyRemote) = AgencyLocal(
        id = agencyRemote.id,
        url = agencyRemote.url,
        name = agencyRemote.name,
        countryCode = agencyRemote.countryCode,
        administrator = agencyRemote.administrator,
        foundingYear = agencyRemote.foundingYear,
        totalLaunchCount = agencyRemote.totalLaunchCount,
        logoUrl = agencyRemote.logoUrl
    )
}
