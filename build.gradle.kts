group = "org.dk.selenk"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.5.21"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.dk.selenk:common:1.0-SNAPSHOT")
    implementation("io.appium:java-client:7.5.1")
    implementation("com.codeborne:selenide:5.23.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("io.mockk:mockk:1.11.0")
}
