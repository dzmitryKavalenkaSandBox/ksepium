package org.dk.selenk.ksepium.driverconfig

import com.codeborne.selenide.WebDriverRunner
import org.openqa.selenium.WebDriver
import java.util.concurrent.ConcurrentHashMap

object KSepiumDriverContainer {

    /**
     * Holds all the webdriver instances started for testing.
     * Key - Thread id on which the driver was started.
     * Value - WebDriver instance
     */
    private val webDrivers: Map<Long, WebDriver> = ConcurrentHashMap()

    @JvmStatic
    fun bindDriverToThread(driver: WebDriver) {
        WebDriverRunner.setWebDriver(driver)
    }

    fun getDriver(): WebDriver = WebDriverRunner.getWebDriver()

//    fun <PAGE : KSepiumPage<PAGE>> startNewDriverInstance(pageToLandOn: PAGE, driver: KSepiumDriver): PAGE {
//
//        return pageToLandOn
//    }
}
