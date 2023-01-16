package com.lpirro.repository.mapper

import java.util.Locale

interface DateParser {
    val locale: Locale
    fun parseFullDate(dateString: String): String
    fun parseDateDayMonth(dateString: String): String
    fun parseDateInMillis(dateString: String): Long?
}
