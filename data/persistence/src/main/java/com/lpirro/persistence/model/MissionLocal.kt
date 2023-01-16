package com.lpirro.persistence.model

data class MissionLocal(
    val id: Long,
    val name: String,
    val description: String,
    val type: String,
    val orbit: OrbitLocal?
)
