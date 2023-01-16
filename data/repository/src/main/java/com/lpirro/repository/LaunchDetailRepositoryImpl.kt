package com.lpirro.repository

import com.lpirro.domain.repository.LaunchDetailRepository
import com.lpirro.persistence.room.LaunchDao
import com.lpirro.repository.mapper.LaunchMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LaunchDetailRepositoryImpl(
    private val launchDao: LaunchDao,
    private val mapper: LaunchMapper
) : LaunchDetailRepository {

    override suspend fun getLaunch(id: String) = flow {
        val launch = launchDao.getLaunch(id)
        emit(mapper.mapToDomain(launch))
    }.flowOn(Dispatchers.IO)
}
