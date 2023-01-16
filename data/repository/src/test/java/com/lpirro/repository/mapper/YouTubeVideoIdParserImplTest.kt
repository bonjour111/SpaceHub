package com.lpirro.repository.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class YouTubeVideoIdParserImplTest {

    private lateinit var videoUrlsUnderTest: List<String>
    private lateinit var youTubeVideoIdParser: YouTubeVideoIdParser

    @Before
    fun setup() {
        youTubeVideoIdParser = YouTubeVideoIdParserImpl()
        videoUrlsUnderTest = listOf(
            "https://www.youtube.com/watch?v=DFYRQ_zQ-gk&feature=featured",
            "https://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "https://youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://youtube.com/watch?v=DFYRQ_zQ-gk",
            "https://youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://youtube.com/watch?v=DFYRQ_zQ-gk",
            "https://m.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://m.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://m.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://m.youtube.com/watch?v=DFYRQ_zQ-gk",
            "https://www.youtube.com/v/DFYRQ_zQ-gk?fs=1&hl=en_US",
            "http://www.youtube.com/v/DFYRQ_zQ-gk?fs=1&hl=en_US",
            "http://www.youtube.com/v/DFYRQ_zQ-gk?fs=1&hl=en_US",
            "http://www.youtube.com/v/DFYRQ_zQ-gk?fs=1&hl=en_US",
            "http://youtube.com/v/DFYRQ_zQ-gk?fs=1&hl=en_US",
            "https://www.youtube.com/embed/DFYRQ_zQ-gk?autoplay=1",
            "https://www.youtube.com/embed/DFYRQ_zQ-gk",
            "http://www.youtube.com/embed/DFYRQ_zQ-gk",
            "http://www.youtube.com/embed/DFYRQ_zQ-gk",
            "http://www.youtube.com/embed/DFYRQ_zQ-gk",
            "https://youtube.com/embed/DFYRQ_zQ-gk",
            "http://youtube.com/embed/DFYRQ_zQ-gk",
            "http://youtube.com/embed/DFYRQ_zQ-gk",
            "https://youtube.com/embed/DFYRQ_zQ-gk",
            "https://youtu.be/DFYRQ_zQ-gk?t=120",
            "https://youtu.be/DFYRQ_zQ-gk",
            "http://youtu.be/DFYRQ_zQ-gk",
            "http://youtu.be/DFYRQ_zQ-gk",
            "http://youtu.be/DFYRQ_zQ-gk",
            "https://www.youtube.com/HamdiKickProduction?v=DFYRQ_zQ-gk",
            "https://www.youtube.com/watch?v=DFYRQ_zQ-gk&t=67s",
            "http://www.youtube.com/watch?v=DFYRQ_zQ-gk&a=GxdCwVVULXctT2lYDEPllDR0LRTutYfW",
            "http://www.youtube.com/embed/DFYRQ_zQ-gk",
            "http://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "https://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://www.youtube.com/watch?v=DFYRQ_zQ-gk",
            "http://youtu.be/DFYRQ_zQ-gk",
            "http://www.youtube.com/v/DFYRQ_zQ-gk",
            "http://www.youtube.com/e/DFYRQ_zQ-gk",
            "http://www.youtube.com/watch?feature=player_embedded&v=DFYRQ_zQ-gk",
        )
    }

    @Test
    fun `YouTube Video Urls extract id Correctly`() {
        val expectedId = "DFYRQ_zQ-gk"
        videoUrlsUnderTest.forEach {
            assertEquals(expectedId, youTubeVideoIdParser.getVideoId(it))
        }
    }
}
