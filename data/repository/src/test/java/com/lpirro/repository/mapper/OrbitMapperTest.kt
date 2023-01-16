package com.lpirro.repository.mapper

import com.lpirro.repository.mapper.util.MockMapperUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class OrbitMapperTest {

    lateinit var orbitMapper: OrbitMapper

    @Before
    fun setup() {
        orbitMapper = OrbitMapperImpl()
    }

    @Test
    fun `OrbitLocal to Orbit maps Correctly`() {
        val orbitLocal = MockMapperUtil.mockOrbitLocal()
        val mappedOrbit = orbitMapper.mapToDomain(orbitLocal)

        assertEquals(orbitLocal.id, mappedOrbit.id)
        assertEquals(orbitLocal.name, mappedOrbit.name)
        assertEquals(orbitLocal.abbrev, mappedOrbit.abbrev)
    }

    @Test
    fun `OrbitRemote to OrbitLocal maps Correctly`() {
        val orbitRemote = MockMapperUtil.mockOrbitRemote()
        val mappedOrbit = orbitMapper.mapToLocal(orbitRemote)

        assertEquals(orbitRemote.id, mappedOrbit.id)
        assertEquals(orbitRemote.name, mappedOrbit.name)
        assertEquals(orbitRemote.abbrev, mappedOrbit.abbrev)
    }
}
