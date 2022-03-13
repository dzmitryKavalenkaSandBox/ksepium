package org.dk.selenk.ksepium.driverconfig

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.exception.ErrorCodeDefinition
import org.dk.selenk.common.exception.SelenKException
import org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder.AppiumCapabilitiesBuilder
import org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder.AppiumCapabilitiesBuilder.Companion.buildAppiumDriver

class KAppiumDriver : KSepiumDriver<AppiumDriver<MobileElement>, AppiumCapabilitiesBuilder> {

    override fun initDriver(desiredCapabilities: AppiumCapabilitiesBuilder.() -> Unit): AppiumDriver<MobileElement> {
        val capabilities = buildAppiumDriver(desiredCapabilities)
        return when (SelenKConfig.automationType) {
            AutomationType.UiAutomator2 -> AndroidDriver(SelenKConfig.getAppiumUrl(), capabilities)
            AutomationType.XcUiTest -> IOSDriver(SelenKConfig.getAppiumUrl(), capabilities)
            else -> throw SelenKException("'${SelenKConfig.automationType}' driver type is not supported for " +
                "mobile driver init", ErrorCodeDefinition.INIT_DRIVER_ERROR)
        }
    }
}
