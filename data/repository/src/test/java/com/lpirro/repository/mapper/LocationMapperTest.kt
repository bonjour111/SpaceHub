package com.lpirro.repository.mapper

import com.lpirro.repository.mapper.util.MockMapperUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LocationMapperTest {

    lateinit var locationMapper: LocationMapper

    @Before
    fun setup() {
        locationMapper = LocationMapperImpl()
    }

    @Test
    fun `LocationLocal to Location maps Correctly`() {
        val locationLocal = MockMapperUtil.mockLocationLocal()
        val mappedLocation = locationMapper.mapToDomain(locationLocal)

        assertEquals(locationLocal.id, mappedLocation.id)
        assertEquals(locationLocal.name, mappedLocation.name)
    }

    @Test
    fun `LocationRemote to LocationLocal maps Correctly`() {
        val locationRemote = MockMapperUtil.mockLocationRemote()
        val mappedLocation = locationMapper.mapToLocal(locationRemote)

        assertEquals(locationRemote.id, mappedLocation.id)
        assertEquals(locationRemote.name, mappedLocation.name)
    }
}
