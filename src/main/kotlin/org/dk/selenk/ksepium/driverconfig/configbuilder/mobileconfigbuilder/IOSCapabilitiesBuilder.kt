package org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder

import org.openqa.selenium.remote.DesiredCapabilities

class IOSCapabilitiesBuilder(private val appiumCapabilitiesBuilder: AppiumCapabilitiesBuilder) {

    private val iosCapabilities: DesiredCapabilities = DesiredCapabilities()

    /**
     * Can improve performance
     */
    private var simpleIsVisibleCheck: Boolean = true

    /**
     * Can improve performance
     */
    private var useJSONSource: Boolean = true

    /**
     * Should driver use hardware keyboard
     */
    private var connectHardwareKeyboard: Boolean = false

    private var xcodeOrgId: String = ""

    private var xcodeSigningId: String = ""

    private var useNewWDA: Boolean = true

    fun simpleIsVisibleCheck(simpleIsVisibleCheck: Boolean) = apply {
        this.simpleIsVisibleCheck = simpleIsVisibleCheck
        iosCapabilities.setCapability("simpleIsVisibleCheck", simpleIsVisibleCheck)
    }

    fun useJSONSource(useJSONSource: Boolean) = apply {
        this.useJSONSource = useJSONSource
        iosCapabilities.setCapability("useJSONSource", useJSONSource)
    }

    fun connectHardwareKeyboard(connectHardwareKeyboard: Boolean) = apply {
        this.connectHardwareKeyboard = connectHardwareKeyboard
        iosCapabilities.setCapability("connectHardwareKeyboard", connectHardwareKeyboard)
    }

    fun useNewWDA(useNewWDA: Boolean) = apply {
        this.useNewWDA = useNewWDA
        iosCapabilities.setCapability("useNewWDA", useNewWDA)
    }

    fun xcodeOrgId(xcodeOrgId: String) = apply {
        this.xcodeOrgId = xcodeOrgId
        iosCapabilities.setCapability("xcodeOrgId", xcodeOrgId)
    }

    fun xcodeSigningId(xcodeSigningId: String) = apply {
        this.xcodeSigningId = xcodeSigningId
        iosCapabilities.setCapability("xcodeSigningId", xcodeSigningId)
    }

    fun buildIOSCapabilities(): DesiredCapabilities =
        appiumCapabilitiesBuilder.capabilities.merge(iosCapabilities)
}
