package com.lpirro.persistence.model

data class UpdateLocal(
    val id: Int,
    val profileImage: String?,
    val comment: String?,
    val createdOn: String?,
    val createdBy: String?,
    val infoUrl: String?
)
