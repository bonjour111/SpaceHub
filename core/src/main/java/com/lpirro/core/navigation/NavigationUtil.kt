package com.lpirro.core.navigation

import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest

object NavigationUtil {

    fun launchDetailDeeplink(launchId: String) = NavDeepLinkRequest.Builder
        .fromUri("android-app://com.lpirro.spacehub/launch_detail?launchId=$launchId".toUri())
        .build()
}
