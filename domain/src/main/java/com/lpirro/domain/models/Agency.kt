package com.lpirro.domain.models

data class Agency(
    val id: Int,
    val url: String,
    val name: String,
    val countryCode: String,
    val administrator: String,
    val foundingYear: String,
    val totalLaunchCount: String,
    val logoUrl: String?
)
