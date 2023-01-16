package com.lpirro.launches

import android.os.CountDownTimer
import android.widget.TextView

class CountdownTimerTextView(
    startDateMillis: Long,
    endDateMillis: Long,
    private val textView: TextView
) : CountDownTimer(startDateMillis - endDateMillis, 1000L) {

    override fun onTick(millisUntilFinished: Long) {
        val seconds = (millisUntilFinished) / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24
        val time = buildString {
            append("In ")
            if (days != 0L) appendDays(days)
            appendHours(hours)
            appendMinutes(minutes)
            if (days == 0L) appendSeconds(seconds)
        }
        textView.text = time
    }

    override fun onFinish() {
        this.cancel()
        textView.text = ""
    }

    private fun StringBuilder.appendDays(days: Long): StringBuilder {
        append(days)
        return if (days > 1L) append(" Days ") else append(" Day ")
    }

    private fun StringBuilder.appendMinutes(minutes: Long): StringBuilder {
        return append(minutes % 60).append(" Min ")
    }

    private fun StringBuilder.appendHours(hours: Long): StringBuilder {
        val hoursFormatted = hours.mod(24)
        append(hoursFormatted)
        return if (hoursFormatted > 1L) append(" Hours ") else append(" Hour ")
    }

    private fun StringBuilder.appendSeconds(seconds: Long): StringBuilder {
        return append(seconds % 60).append(" Seconds")
    }
}
