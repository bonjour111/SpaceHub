package com.lpirro.repository.mapper

import com.lpirro.repository.mapper.util.MockMapperUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AgencyMapperTest {

    private lateinit var agencyMapper: AgencyMapper

    @Before
    fun setup() {
        agencyMapper = AgencyMapperImpl()
    }

    @Test
    fun `AgencyLocal to Agency maps Correctly`() {
        val agencyLocal = MockMapperUtil.mockAgencyLocal()
        val mappedAgency = agencyMapper.mapToDomain(agencyLocal)

        assertEquals(agencyLocal.id, mappedAgency.id)
        assertEquals(agencyLocal.url, mappedAgency.url)
        assertEquals(agencyLocal.name, mappedAgency.name)
        assertEquals(agencyLocal.countryCode, mappedAgency.countryCode)
        assertEquals(agencyLocal.administrator, mappedAgency.administrator)
        assertEquals(agencyLocal.foundingYear, mappedAgency.foundingYear)
        assertEquals(agencyLocal.totalLaunchCount, mappedAgency.totalLaunchCount.toInt())
        assertEquals(agencyLocal.logoUrl, mappedAgency.logoUrl)
    }

    @Test
    fun `AgencyLocal to Agency returns NA when totalLaunchCount is null`() {
        val agencyLocal = MockMapperUtil.mockAgencyLocal(totalLaunchCount = null)
        val mappedAgency = agencyMapper.mapToDomain(agencyLocal)

        assertEquals("N/A", mappedAgency.totalLaunchCount)
    }

    @Test
    fun `AgencyRemote to AgencyLocal maps Correctly`() {
        val agencyRemote = MockMapperUtil.mockAgencyRemote()
        val mappedAgency = agencyMapper.mapToLocal(agencyRemote)

        assertEquals(agencyRemote.id, mappedAgency.id)
        assertEquals(agencyRemote.url, mappedAgency.url)
        assertEquals(agencyRemote.name, mappedAgency.name)
        assertEquals(agencyRemote.countryCode, mappedAgency.countryCode)
        assertEquals(agencyRemote.administrator, mappedAgency.administrator)
        assertEquals(agencyRemote.foundingYear, mappedAgency.foundingYear)
        assertEquals(agencyRemote.totalLaunchCount, mappedAgency.totalLaunchCount)
        assertEquals(agencyRemote.logoUrl, mappedAgency.logoUrl)
    }
}
