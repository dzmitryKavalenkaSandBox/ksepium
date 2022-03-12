rootProject.name = "ksepium"

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.jetbrains.kotlin.")) {
                this.useVersion(gradle.rootProject.properties["kotlinVersion"].toString())
            }
        }
    }
}
