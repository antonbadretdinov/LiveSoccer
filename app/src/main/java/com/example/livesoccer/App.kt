package com.example.livesoccer

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "311aab98-5ebf-40cc-928e-ce313d047113"

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.promptForPushNotifications()
    }
}