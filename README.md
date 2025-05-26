# version-catalog
[![badge-license]][url-license]
[![badge-latest-release]][url-latest-release]

A [VersionCatalog][url-gradle-docs] for the latest versions of **all** [KotlinCrypto][url-kotlin-crypto] dependencies

See the [TOML file](gradle/kotlincrypto.versions.toml) for what is included

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
            // https://github.com/KotlinCrypto/version-catalog/blob/master/gradle/kotlincrypto.versions.toml
            from("org.kotlincrypto:version-catalog:0.7.1")
        }
    }
}
```

Use in your projects
```kotlin
dependencies {
    implementation(kotlincrypto.bitops.bits)
    implementation(kotlincrypto.bitops.endian)

    implementation(kotlincrypto.hash.blake2)
    implementation(kotlincrypto.hash.md)
    implementation(kotlincrypto.hash.sha1)
    implementation(kotlincrypto.hash.sha2)
    implementation(kotlincrypto.hash.sha3)

    implementation(kotlincrypto.macs.blake2)
    implementation(kotlincrypto.macs.hmac.md)
    implementation(kotlincrypto.macs.hmac.sha1)
    implementation(kotlincrypto.macs.hmac.sha2)
    implementation(kotlincrypto.macs.hmac.sha3)
    implementation(kotlincrypto.macs.kmac)

    implementation(kotlincrypto.random.crypto.rand)
}
```

<!-- TAG_VERSION -->
[badge-latest-release]: https://img.shields.io/badge/latest--release-0.7.1-blue.svg?style=flat
[badge-license]: https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat

[url-latest-release]: https://github.com/KotlinCrypto/version-catalog/releases/latest
[url-license]: https://www.apache.org/licenses/LICENSE-2.0.txt
[url-kotlin-crypto]: https://github.com/KotlinCrypto
[url-gradle-docs]: https://docs.gradle.org/current/userguide/platforms.html#sec:importing-published-catalog
