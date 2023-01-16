package com.lpirro.repository.mapper

import com.lpirro.domain.models.Orbit
import com.lpirro.network.models.OrbitRemote
import com.lpirro.persistence.model.OrbitLocal
import com.lpirro.repository.mapper.util.MockMapperUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class MissionMapperTest {

    lateinit var missionMapper: MissionMapper
    private var orbitMapper: OrbitMapper = mock()

    @Before
    fun setup() {
        missionMapper = MissionMapperImpl(orbitMapper)
        whenever(orbitMapper.mapToLocal(any())).thenReturn(MockMapperUtil.mockOrbitLocal())
        whenever(orbitMapper.mapToDomain(any())).thenReturn(MockMapperUtil.mockOrbit())
    }

    @Test
    fun `MissionLocal to Mission maps Correctly`() {
        val missionLocal = MockMapperUtil.mockMissionLocal()
        val mappedMission = missionMapper.mapToDomain(missionLocal)

        assertEquals(missionLocal.id, mappedMission.id)
        assertEquals(missionLocal.name, mappedMission.name)
        assertEquals(missionLocal.description, mappedMission.description)
        assertEquals(missionLocal.type, mappedMission.type)
        assertOrbit(missionLocal.orbit!!, mappedMission.orbit!!)
    }

    @Test
    fun `MissionRemote to MissionLocal maps Correctly`() {
        val missionRemote = MockMapperUtil.mockMissionRemote()
        val mappedMission = missionMapper.mapToLocal(missionRemote)

        assertEquals(missionRemote.id, mappedMission.id)
        assertEquals(missionRemote.name, mappedMission.name)
        assertEquals(missionRemote.description, mappedMission.description)
        assertEquals(missionRemote.type, mappedMission.type)
        assertOrbit(missionRemote.orbit!!, mappedMission.orbit!!)
    }

    private fun assertOrbit(orbitLocal: OrbitLocal, orbit: Orbit) {
        assertEquals(orbitLocal.id, orbit.id)
        assertEquals(orbitLocal.name, orbit.name)
        assertEquals(orbitLocal.abbrev, orbit.abbrev)
    }

    private fun assertOrbit(orbitRemote: OrbitRemote, orbitLocal: OrbitLocal) {
        assertEquals(orbitRemote.id, orbitLocal.id)
        assertEquals(orbitRemote.name, orbitLocal.name)
        assertEquals(orbitRemote.abbrev, orbitLocal.abbrev)
    }
}
