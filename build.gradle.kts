group = "org.dk.selenk"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm")
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.dk.selenk:common:1.0-SNAPSHOT")
    implementation("io.appium:java-client:7.6.0")
    implementation("com.codeborne:selenide:5.23.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("io.mockk:mockk:1.12.3")
}

tasks {
    test {
        useJUnitPlatform { }
    }
}