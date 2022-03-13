package org.dk.selenk.ksepium.driverconfig

import com.codeborne.selenide.WebDriverRunner
import io.appium.java_client.service.local.AppiumDriverLocalService
import io.appium.java_client.service.local.AppiumServiceBuilder
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.SelenKConfig.enableAppiumLogs
import org.openqa.selenium.WebDriver
import java.util.concurrent.ConcurrentHashMap

object KSepiumDriverManager {

    /**
     * Holds all the webdriver instances started for testing.
     * Key - Thread id on which the driver was started.
     * Value - WebDriver instance
     */
    private val webDrivers: MutableMap<Long, WebDriver> = ConcurrentHashMap()

    private var appiumDriverLocalService: MutableMap<Long, AppiumDriverLocalService> = ConcurrentHashMap()

//    fun createDriver(block: KSepiumDriver<*>.()-> Unit) {
//        bindDriverToThread(block() as WebDriver)
//    }

    @JvmStatic
    fun bindDriverToThread(driver: WebDriver) {
        WebDriverRunner.setWebDriver(driver)
    }

    fun getDriver(): WebDriver = WebDriverRunner.getWebDriver()

    fun getAppiumLocalService(): AppiumDriverLocalService? =
        appiumDriverLocalService[Thread.currentThread().id]

    fun startAppiumServer() {
        appiumDriverLocalService[Thread.currentThread().id] =
            AppiumDriverLocalService.buildService(
                AppiumServiceBuilder().usingAnyFreePort()
                    .withArgument({ "--base-path" }, "wd/hub")
                    .withArgument { "--relaxed-security" }
            )
        getAppiumLocalService()?.start()
        SelenKConfig.setAppiumUrl(getAppiumLocalService()?.url!!.toString())
        if (!enableAppiumLogs) getAppiumLocalService()?.clearOutPutStreams()
    }

    fun startAppiumServer(builderFunction: AppiumServiceBuilder.() -> Unit) {
        val builder = AppiumServiceBuilder()
        builder.builderFunction()
        val service = builder.build()
        appiumDriverLocalService[Thread.currentThread().id] = service
        getAppiumLocalService()?.start()
        SelenKConfig.setAppiumUrl(getAppiumLocalService()?.url!!.toString())
        if (!enableAppiumLogs) getAppiumLocalService()?.clearOutPutStreams()
    }

    fun killAppiumServerFor() {
        if (getAppiumLocalService() != null) {
            getAppiumLocalService()!!.stop()
        }
    }
}
