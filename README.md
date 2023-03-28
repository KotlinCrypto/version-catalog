# version-catalog
[![badge-license]][url-license]
[![badge-latest-release]][url-latest-release]

A [VersionCatalog][url-gradle-docs] for the latest versions of **all** [KotlinCrypto][url-kotlin-crypto] dependencies

### Get Started

<!-- TAG_VERSION -->

Add to your `settings.gradle.kts` file
```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

    versionCatalogs {
        create("kotlincrypto") {
            from("org.kotlincrypto:version-catalog:0.2.1")
        }
    }
}
```

Use in your projects
```kotlin
dependencies {
    implementation(kotlincrypto.hash.sha2)
    implementation(kotlincrypto.macs.hmac.sha2)
    implementation(kotlincrypto.secureRandom)
}
```

See the [TOML file](gradle/kotlincrypto.versions.toml) for what is included!

<!-- TAG_VERSION -->
[badge-latest-release]: https://img.shields.io/badge/latest--release-0.2.1-blue.svg?style=flat
[badge-license]: https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat

[url-latest-release]: https://github.com/KotlinCrypto/version-catalog/releases/latest
[url-license]: https://www.apache.org/licenses/LICENSE-2.0.txt
[url-kotlin-crypto]: https://github.com/KotlinCrypto
[url-gradle-docs]: https://docs.gradle.org/current/userguide/platforms.html#sec:importing-published-catalog
