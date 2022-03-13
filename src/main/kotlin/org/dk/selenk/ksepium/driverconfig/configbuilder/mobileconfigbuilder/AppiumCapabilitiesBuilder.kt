package org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder

import io.appium.java_client.remote.MobileCapabilityType
import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.Platform
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.util.platfromexec.SelenKBuilderMarker
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

@SelenKBuilderMarker
class AppiumCapabilitiesBuilder(val capabilities: DesiredCapabilities = DesiredCapabilities()) :
    DriverCapabilityBuilder<AppiumCapabilitiesBuilder>() {

    /**
     * Path to '.apk' file on android and '.app' for iOS ('.ipa' for real iOS device)
     */
    private var applicationPath: String? = null

//    /**
//     * Package of application under test, e.g. org.some.test
//     */
//    private var applicationPackage: String? = null

    /**
     * Unique device identifier.
     */
    private var deviceUDID: String? = null

    /**
     * Name of the platform. ios - iOS, android - Android
     */
    private var platformName: String? = null

    /**
     * Name of device to run tests on
     */
    private var deviceName: String? = null

    /**
     * Type of driver for automation
     */
    private var automationName: String? = null

    /**
     * Time(in seconds) appium will wait till deciding that application has terminated and end session
     */
    private var newCommandTimeout: Int = 0

    /**
     * Have Appium automatically determine which permissions your app requires and grant them to the app on install.
     * If noReset is true, this capability doesn't work.
     */
    private var autoGrandPermissions: Boolean = false

    /**
     * Should application be fully reset before run (clearing all the app data)
     */
    private var enableFullReset: Boolean = true

    /**
     * Version of platform OS
     */
    private var platformVersion: String = ""


    companion object {
        inline fun buildAppiumDriver(buildAppiumDriver: AppiumCapabilitiesBuilder.() -> Unit): DesiredCapabilities {
            val builder = AppiumCapabilitiesBuilder()
            builder.buildAppiumDriver()
            return builder.build()
        }
    }


    fun pathToApplication(applicationPath: String) = apply {
        this.applicationPath = applicationPath
        capabilities.setCapability(MobileCapabilityType.APP, this.applicationPath)
    }

    fun deviceUDID(deviceUDID: String) = apply {
        this.deviceUDID = deviceUDID
        capabilities.setCapability(MobileCapabilityType.UDID, this.deviceUDID)
    }

    fun deviceName(deviceName: String) = apply {
        this.deviceName = deviceName
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, this.deviceName)
    }

    fun platform(platform: Platform) = apply {
        this.platformName = platform.name
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, this.platformName)
        SelenKConfig.platform = platform
    }

    fun platform(platform: String) = apply {
        val resolvedPlatform = Platform.fromString(platform)
        this.platformName = resolvedPlatform.name
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, this.platformName)
        SelenKConfig.platform = resolvedPlatform
    }

    fun automationType(automationType: AutomationType) = apply {
        this.automationName = automationType.type
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, this.automationName)
        SelenKConfig.automationType = automationType
    }

    fun automationType(automationType: String) = apply {
        val resolvedAutomationType = AutomationType.fromString(automationType)
        this.automationName = resolvedAutomationType.type
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, this.automationName)
        SelenKConfig.automationType = resolvedAutomationType
    }

    fun newCommandTimeout(newCommandTimeout: Int) = apply {
        this.newCommandTimeout = newCommandTimeout
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, this.newCommandTimeout)
    }

    fun enableFullReset() = apply {
        this.enableFullReset = true
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, this.enableFullReset)
    }

    fun disableFullReset() = apply {
        this.enableFullReset = false
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, this.enableFullReset)
    }

    fun platformVersion(version: String) = apply {
        this.platformVersion = version
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version)
    }

    fun forAndroid(androidCapabilitiesBuilder: AndroidCapabilitiesBuilder.() -> Unit) = apply {
        val builder = AndroidCapabilitiesBuilder(this)
        builder.androidCapabilitiesBuilder()
        builder.buildAndroidCapabilities()
    }

    fun forIOS(iosCapabilitiesBuilder: IOSCapabilitiesBuilder.() -> Unit) = apply {
        val builder = IOSCapabilitiesBuilder(this)
        builder.iosCapabilitiesBuilder()
        builder.buildIOSCapabilities()
    }

    override fun build(): DesiredCapabilities =
        capabilities
}
