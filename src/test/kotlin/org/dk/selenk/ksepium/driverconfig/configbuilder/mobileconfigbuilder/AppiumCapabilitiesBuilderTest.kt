package org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder

import io.appium.java_client.remote.MobileCapabilityType
import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.Platform
import org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder.AppiumCapabilitiesBuilder.Companion.buildAppiumDriver
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.openqa.selenium.remote.CapabilityType

class AppiumCapabilitiesBuilderTest {

    @Test
    fun builderTest() {
        val capabilities = buildAppiumDriver {
            platform(Platform.AndroidTab)
            disableFullReset()
            deviceName("testDevice")
            forAndroid {
                appWaitActivity("com.example.com")
            }
            automationType(AutomationType.UiAutomator2)
            newCommandTimeout(200)
            deviceUDID("testUdid")
            pathToApplication("path/to/app")
        }

        assertThat(capabilities.getCapability(MobileCapabilityType.AUTOMATION_NAME).toString(), `is`(AutomationType.UiAutomator2.type))
        assertThat(capabilities.getCapability("appWaitActivity").toString(), `is`("com.example.com"))
        assertThat(capabilities.getCapability(CapabilityType.PLATFORM_NAME).toString(), `is`(Platform.AndroidTab.name))
        assertThat(capabilities.getCapability(MobileCapabilityType.FULL_RESET).toString(), `is`("false"))
        assertThat(capabilities.getCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT).toString(), `is`("200"))
        assertThat(capabilities.getCapability(MobileCapabilityType.DEVICE_NAME).toString(), `is`("testDevice"))
        assertThat(capabilities.getCapability(MobileCapabilityType.UDID).toString(), `is`("testUdid"))
        assertThat(capabilities.getCapability(MobileCapabilityType.APP).toString(), `is`("path/to/app"))
    }
}
