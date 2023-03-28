@file:Suppress("UnstableApiUsage")

rootProject.name = "version-catalog"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("kotlincrypto") {
            from(files("gradle/kotlincrypto.versions.toml"))
        }
    }
}

includeBuild("build-logic")

listOf(
    "stub",
    "version-catalog",
).forEach { name ->
    include(":$name")
}
