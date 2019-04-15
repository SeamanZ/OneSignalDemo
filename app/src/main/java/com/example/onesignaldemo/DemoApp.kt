package com.example.onesignaldemo

import android.app.Application
import android.util.Log
import com.onesignal.OneSignal

const val TAG = "DemoApp"

/**
 * Created by Seaman on 2019/4/15.
 * Bangggood Ltd
 */
class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // OneSignal Initialization
        if (BuildConfig.DEBUG) {
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.DEBUG, OneSignal.LOG_LEVEL.NONE)
        }
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.InAppAlert)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init()

        OneSignal.idsAvailable { userId, registrationId ->

            Log.v(TAG, "userId = $userId  registrationId = $registrationId")
        }


    }


}