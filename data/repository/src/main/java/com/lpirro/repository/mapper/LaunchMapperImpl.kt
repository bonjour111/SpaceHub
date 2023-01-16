package com.lpirro.repository.mapper

import com.lpirro.domain.models.Launch
import com.lpirro.network.models.LaunchRemote
import com.lpirro.persistence.model.LaunchLocal
import com.lpirro.persistence.model.LaunchType

class LaunchMapperImpl(
    private val agencyMapper: AgencyMapper,
    private val missionPatchMapper: MissionPatchMapper,
    private val padMapper: PadMapper,
    private val dateParser: DateParser,
    private val statusMapper: StatusMapper,
    private val youTubeVideoIdParser: YouTubeVideoIdParser,
    private val missionMapper: MissionMapper,
    private val updateMapper: UpdateMapper
) : LaunchMapper {
    override fun mapToDomain(launchLocal: LaunchLocal) = Launch(
        id = launchLocal.id,
        name = launchLocal.name,
        image = launchLocal.image,
        launchServiceProvider = agencyMapper.mapToDomain(launchLocal.launchServiceProvider),
        missionPatches = launchLocal.missionPatches?.map { missionPatchMapper.mapToDomain(it) },
        pad = padMapper.mapToDomain(launchLocal.pad),
        mission = launchLocal.mission?.let { missionMapper.mapToDomain(it) },
        net = launchLocal.net?.let { dateParser.parseFullDate(it) },
        windowStart = launchLocal.windowStart?.let { dateParser.parseFullDate(it) },
        windowEnd = launchLocal.windowEnd?.let { dateParser.parseFullDate(it) },
        netMillis = launchLocal.net?.let { dateParser.parseDateInMillis(it) },
        status = statusMapper.mapToDomain(launchLocal.status),
        youtubeVideoId = launchLocal.liveVideoUrl?.let { youTubeVideoIdParser.getVideoId(it) },
        infoUrl = launchLocal.infoUrl,
        flightClubUrl = launchLocal.flightClubUrl,
        updates = launchLocal.updates?.map { updateMapper.mapToDomain(it) }
    )

    override fun mapToLocal(launchRemote: LaunchRemote, launchType: LaunchType?) = LaunchLocal(
        id = launchRemote.id,
        name = launchRemote.name,
        image = launchRemote.image,
        launchServiceProvider = agencyMapper.mapToLocal(launchRemote.launchServiceProvider),
        missionPatches = launchRemote.missionPatches?.map { missionPatchMapper.mapToLocal(it) },
        pad = padMapper.mapToLocal(launchRemote.pad),
        mission = launchRemote.mission?.let { missionMapper.mapToLocal(it) },
        net = launchRemote.net,
        windowStart = launchRemote.windowStart,
        windowEnd = launchRemote.windowEnd,
        status = statusMapper.mapToLocal(launchRemote.status),
        type = launchType,
        liveVideoUrl = launchRemote.videoUrls.firstOrNull()?.url,
        infoUrl = launchRemote.infoURLs?.firstOrNull()?.url,
        flightClubUrl = launchRemote.flightClubUrl,
        updates = launchRemote.updates?.map { updateMapper.mapToLocal(it) }
    )
}
