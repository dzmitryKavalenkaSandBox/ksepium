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
}
