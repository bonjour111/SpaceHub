package com.lpirro.repository.mapper

import com.lpirro.repository.mapper.util.MockMapperUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class StatusMapperTest {

    lateinit var statusMapper: StatusMapper

    @Before
    fun setup() {
        statusMapper = StatusMapperImpl()
    }

    @Test
    fun `StatusLocal to Status maps Correctly`() {
        val statusLocal = MockMapperUtil.mockStatusLocal()
        val mappedStatus = statusMapper.mapToDomain(statusLocal)

        assertEquals(statusLocal.id, mappedStatus.id)
        assertEquals(statusLocal.name, mappedStatus.name)
        assertEquals(statusLocal.abbrev, mappedStatus.abbrev)
        assertEquals(statusLocal.description, mappedStatus.description)
    }

    @Test
    fun `StatusRemote to StatusLocal maps Correctly`() {
        val statusRemote = MockMapperUtil.mockStatusRemote()
        val mappedStatus = statusMapper.mapToLocal(statusRemote)

        assertEquals(statusRemote.id, mappedStatus.id)
        assertEquals(statusRemote.name, mappedStatus.name)
        assertEquals(statusRemote.abbrev, mappedStatus.abbrev)
        assertEquals(statusRemote.description, mappedStatus.description)
    }
}
