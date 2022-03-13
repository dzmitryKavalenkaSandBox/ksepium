package org.dk.selenk.ksepium.driverconfig

import org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder.DriverCapabilityBuilder
import org.openqa.selenium.WebDriver

interface KSepiumDriver<DRIVER : WebDriver, BUILDER: DriverCapabilityBuilder<BUILDER>> {

    fun initDriver(desiredCapabilities: BUILDER.() -> Unit): DRIVER
}
