package com.lpirro.repository.mapper

import com.lpirro.repository.mapper.util.MockMapperUtil
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MissionPatchesMapperTest {

    private lateinit var missionPatchMapper: MissionPatchMapper

    @Before
    fun setup() {
        missionPatchMapper = MissionPatchesMapperImpl()
    }

    @Test
    fun `MissionPatchesLocal to MissionPatches maps Correctly`() {
        val missionPatchesLocal = MockMapperUtil.mockMissionPatchesLocal()
        val mappedMissionPatch = missionPatchMapper.mapToDomain(missionPatchesLocal)

        assertEquals(missionPatchesLocal.id, mappedMissionPatch.id)
        assertEquals(missionPatchesLocal.name, mappedMissionPatch.name)
        assertEquals(missionPatchesLocal.imageUrl, mappedMissionPatch.imageUrl)
    }

    @Test
    fun `MissionPatchesRemote to MissionPatchesLocal maps Correctly`() {
        val missionPatchesRemote = MockMapperUtil.mockMissionPatchesRemote()
        val mappedMissionPatch = missionPatchMapper.mapToLocal(missionPatchesRemote)

        assertEquals(missionPatchesRemote.id, mappedMissionPatch.id)
        assertEquals(missionPatchesRemote.name, mappedMissionPatch.name)
        assertEquals(missionPatchesRemote.imageUrl, mappedMissionPatch.imageUrl)
    }
}
