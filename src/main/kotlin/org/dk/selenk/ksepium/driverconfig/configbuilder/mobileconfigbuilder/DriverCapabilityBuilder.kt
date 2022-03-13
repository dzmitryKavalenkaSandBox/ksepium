package org.dk.selenk.ksepium.driverconfig.configbuilder.mobileconfigbuilder

import org.openqa.selenium.remote.DesiredCapabilities

abstract class DriverCapabilityBuilder<BUILDER: DriverCapabilityBuilder<BUILDER>> {

    abstract fun build(): DesiredCapabilities
}