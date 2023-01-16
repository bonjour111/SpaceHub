package com.lpirro.repository.mapper

import java.util.regex.Pattern

private const val YOUTUBE_VIDEO_ID_REGEX =
    "http(?:s)?:\\/\\/(?:m.)?(?:www\\.)?youtu(?:\\.be\\/|(?:be-nocookie|be)\\.com\\/(?:watch|[\\w]+\\?(?:feature=[\\w]+.[\\w]+\\&)?v=|v\\/|e\\/|embed\\/|user\\/(?:[\\w#]+\\/)+))([^&#?\\n]+)"

class YouTubeVideoIdParserImpl : YouTubeVideoIdParser {

    override fun getVideoId(videoUrl: String): String? {
        val pattern = Pattern.compile(YOUTUBE_VIDEO_ID_REGEX, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(videoUrl)
        if (matcher.find()) {
            return matcher.group(1)
        }
        return null // TODO: Add analytics if the mapper fails to map youtube video
    }
}
