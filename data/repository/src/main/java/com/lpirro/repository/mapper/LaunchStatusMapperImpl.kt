/*
 * SpaceHub - Designed and Developed by LPirro (Leonardo Pirro)
 * Copyright (C) 2023 Leonardo Pirro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.lpirro.repository.mapper

import com.lpirro.domain.models.LaunchStatus
import com.lpirro.network.models.LaunchStatusRemote
import com.lpirro.persistence.model.LaunchStatusLocal

class LaunchStatusMapperImpl : LaunchStatusMapper {
    override fun mapToDomain(launchStatusLocal: LaunchStatusLocal): LaunchStatus {
        return when (launchStatusLocal.id) {
            1 -> LaunchStatus.Go(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
            2 -> LaunchStatus.TBD(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
            3 -> LaunchStatus.Success(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
            4 -> LaunchStatus.Failure(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
            6 -> LaunchStatus.InFlight(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
            8 -> LaunchStatus.TBC(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
            else -> LaunchStatus.Unknown(
                name = launchStatusLocal.name,
                abbrev = launchStatusLocal.abbrev,
                description = launchStatusLocal.description
            )
        }
    }

    override fun mapToLocal(launchStatusRemote: LaunchStatusRemote) = LaunchStatusLocal(
        id = launchStatusRemote.id,
        name = launchStatusRemote.name,
        abbrev = launchStatusRemote.abbrev,
        description = launchStatusRemote.description
    )
}
