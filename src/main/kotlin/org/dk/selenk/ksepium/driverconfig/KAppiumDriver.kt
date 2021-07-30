package org.dk.selenk.ksepium.driverconfig

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement

class KAppiumDriver : KSepiumDriver<AppiumDriver<MobileElement>> {

    override fun initDriver(): AppiumDriver<MobileElement> {
        TODO("Not yet implemented")
    }
}
