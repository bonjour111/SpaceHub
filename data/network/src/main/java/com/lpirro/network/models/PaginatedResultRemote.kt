package com.lpirro.network.models

data class PaginatedResultRemote<T>(val next: String?, val previous: String?, val results: T)
