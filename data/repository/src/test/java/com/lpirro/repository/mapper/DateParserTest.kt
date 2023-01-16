package com.lpirro.repository.mapper

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.LocaleList
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Spy
import org.mockito.kotlin.mock
import java.util.Locale

class DateParserTest {

    private lateinit var dateUnderTest: String

    @Spy
    private lateinit var dateParser: DateParser
    private var applicationContext: Context = mock()

    @Before
    fun setup() {
        val resources: Resources = mock()
        val configuration: Configuration = mock()
        val localeList: LocaleList = mock()

        `when`(applicationContext.resources).thenReturn(resources)
        `when`(applicationContext.resources.configuration).thenReturn(configuration)
        `when`(applicationContext.resources.configuration.locales).thenReturn(localeList)
        `when`(applicationContext.resources.configuration.locales.get(0)).thenReturn(Locale.US)
        dateParser = DateParserImpl(applicationContext)

        dateUnderTest = "2022-12-25T09:30:00Z"
    }

    @Test
    fun `Full Date parsed correctly in dd MMM yyyy HHmm`() {
        val expectedResult = "25 Dec 2022 • 10:30"
        val result = dateParser.parseFullDate(dateUnderTest)

        assertEquals(result, expectedResult)
    }

    @Test
    fun `Date Day Month parsed correctly in dd MMM`() {
        val expectedResult = "25 Dec"
        val result = dateParser.parseDateDayMonth(dateUnderTest)

        assertEquals(result, expectedResult)
    }

    @Test
    fun `Date parsed correctly in milliseconds`() {
        val expectedResult = 1671960600000
        val result = dateParser.parseDateInMillis(dateUnderTest)

        assertEquals(result, expectedResult)
    }

    @Test
    fun `Unparselable Full Date returns -`() {
        val dateUnderTest = "2022-12-20Z"
        val result = dateParser.parseFullDate(dateUnderTest)

        assertEquals(result, "-")
    }

    @Test
    fun `Unparselable Date Day Month returns -`() {
        val dateUnderTest = "2022-12-20Z"
        val result = dateParser.parseDateDayMonth(dateUnderTest)

        assertEquals(result, "-")
    }
}
