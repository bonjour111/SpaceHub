package com.lpirro.repository.mapper

interface YouTubeVideoIdParser {
    fun getVideoId(videoUrl: String): String?
}
