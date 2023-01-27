/*
 *
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
 *
 */

package com.lpirro.domain.models

sealed class Status(
    open val name: String,
    open val abbrev: String,
    open val description: String
) {
    data class TBD(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)

    data class TBC(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)

    data class Go(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)

    data class Success(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)

    data class Failure(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)

    data class InFlight(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)

    data class Unknown(
        override val name: String,
        override val abbrev: String,
        override val description: String
    ) : Status(name, abbrev, description)
}
