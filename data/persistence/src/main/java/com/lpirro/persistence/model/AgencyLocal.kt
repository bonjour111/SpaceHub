package com.lpirro.persistence.model

data class AgencyLocal(
    val id: Int,
    val url: String,
    val name: String,
    val countryCode: String,
    val administrator: String?,
    val foundingYear: String?,
    val totalLaunchCount: Int?,
    val logoUrl: String?
)
