package org.dk.selenk.ksepium.driverconfig

import org.openqa.selenium.WebDriver

interface KSepiumDriver<DRIVER : WebDriver> {

    fun initDriver(): DRIVER
}
