package com.lpirro.repository.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MapPositionMapperTest {

    lateinit var mapPositionMapper: MapPositionMapper

    @Before
    fun setup() {
        mapPositionMapper = MapPositionMapperImpl()
    }

    @Test
    fun `mapPositionMapper maps correctly`() {
        val mappedResult = mapPositionMapper.mapToDomain("150", "200.0")
        assertEquals(150.0, mappedResult!!.latitude, 0.0)
        assertEquals(200.0, mappedResult.longitude, 0.0)
    }

    @Test
    fun `mapPositionMapper null latitude returns null as result of the mapping`() {
        val mappedResult = mapPositionMapper.mapToDomain(null, "200.0")
        assertEquals(mappedResult, null)
    }

    @Test
    fun `mapPositionMapper null longitude returns null as result of the mapping`() {
        val mappedResult = mapPositionMapper.mapToDomain("200.0", null)
        assertEquals(mappedResult, null)
    }

    @Test
    fun `mapPositionMapper null longitude and null latitude returns null as result of the mapping`() {
        val mappedResult = mapPositionMapper.mapToDomain(null, null)
        assertEquals(mappedResult, null)
    }
}
