package com.lpirro.repository.mapper

import com.lpirro.domain.models.Agency
import com.lpirro.network.models.AgencyRemote
import com.lpirro.persistence.model.AgencyLocal

interface AgencyMapper {
    fun mapToDomain(agencyLocal: AgencyLocal): Agency
    fun mapToLocal(agencyRemote: AgencyRemote): AgencyLocal
}
