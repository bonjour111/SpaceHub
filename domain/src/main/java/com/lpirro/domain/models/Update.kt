package com.lpirro.domain.models

data class Update(
    val id: Int,
    val profileImage: String?,
    val comment: String?,
    val createdOn: String?,
    val createdBy: String?,
    val infoUrl: String?
)
