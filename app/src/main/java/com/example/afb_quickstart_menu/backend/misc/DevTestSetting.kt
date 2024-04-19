package com.example.afb_quickstart_menu.backend.misc

import com.example.afb_quickstart_menu.frontend.activity.FileSelectorActivity

internal class DevTestSetting {
    companion object {
        private val skipList = arrayOf(
            FileSelectorActivity::class.java
        )

        val hideDebugUI = false
        val skipSplashPage = true
        val skipToClass = skipList[0]
    }
}