package com.lpirro.domain.models

data class Mission(
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    val orbit: Orbit?
)
