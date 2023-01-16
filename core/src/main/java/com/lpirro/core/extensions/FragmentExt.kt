package com.lpirro.core.extensions

import android.content.Intent
import android.net.Uri
import android.provider.CalendarContract
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment

fun Fragment.launchGoogleMapsIntent(mapUrl: String) {
    val gmmIntentUri = Uri.parse(mapUrl)
    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
    mapIntent.setPackage("com.google.android.apps.maps")
    startActivity(mapIntent)
}

fun Fragment.launchChromeCustomTab(url: String) {
    val builder = CustomTabsIntent.Builder()
    val customTabsIntent = builder.build()
    customTabsIntent.launchUrl(requireContext(), Uri.parse(url))
}

fun Fragment.launchAddToCalendarIntent(title: String, dateMillis: Long) {
    val intent = Intent(Intent.ACTION_EDIT)
    intent.type = "vnd.android.cursor.item/event"
    intent.putExtra(CalendarContract.Events.TITLE, title)
    intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, dateMillis)
    intent.putExtra(CalendarContract.Events.ALL_DAY, false)
    startActivity(intent)
}
