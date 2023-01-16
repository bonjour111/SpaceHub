package com.lpirro.repository.mapper

import com.lpirro.domain.models.Pad
import com.lpirro.network.models.PadRemote
import com.lpirro.persistence.model.PadLocal

interface PadMapper {
    fun mapToDomain(padLocal: PadLocal): Pad

    fun mapToLocal(padRemote: PadRemote): PadLocal
}
