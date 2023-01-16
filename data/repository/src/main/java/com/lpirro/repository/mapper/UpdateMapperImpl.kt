package com.lpirro.repository.mapper

import com.lpirro.domain.models.Update
import com.lpirro.network.models.UpdateRemote
import com.lpirro.persistence.model.UpdateLocal

class UpdateMapperImpl(private val dateParser: DateParser) : UpdateMapper {
    override fun mapToDomain(updateLocal: UpdateLocal) = Update(
        id = updateLocal.id,
        profileImage = updateLocal.profileImage,
        comment = updateLocal.comment,
        createdOn = updateLocal.createdOn,
        createdBy = updateLocal.createdBy,
        infoUrl = updateLocal.infoUrl
    )

    override fun mapToLocal(updateRemote: UpdateRemote) = UpdateLocal(
        id = updateRemote.id,
        profileImage = updateRemote.profileImage,
        comment = updateRemote.comment,
        createdOn = updateRemote.createdOn?.let { dateParser.parseDateDayMonth(it) },
        createdBy = updateRemote.createdBy,
        infoUrl = updateRemote.infoUrl
    )
}
