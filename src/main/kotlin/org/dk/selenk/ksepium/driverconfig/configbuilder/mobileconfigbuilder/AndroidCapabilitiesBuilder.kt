package org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder

import org.openqa.selenium.remote.DesiredCapabilities

class AndroidCapabilitiesBuilder(private val appiumCapabilitiesBuilder: AppiumCapabilitiesBuilder) {

    private val androidCapabilities: DesiredCapabilities = DesiredCapabilities()

    /**
     * Activity we should wait to be present after application has launched.
     * **See Also:** [AppiumCapabilities] (https://appium.io/docs/en/writing-running-appium/caps/#android-only)
     */
    private var appWaitActivity: String? = null

    fun appWaitActivity(appWaitActivity: String) = apply {
        this.appWaitActivity = appWaitActivity
        androidCapabilities.setCapability("appWaitActivity", appWaitActivity)
    }

    fun buildAndroidCapabilities(): DesiredCapabilities = appiumCapabilitiesBuilder.capabilities.merge(androidCapabilities)
}
