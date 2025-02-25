/*
 * Copyright (c) 2023 KotlinCrypto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id("configuration")
}

kmpConfiguration {
    configure {
        options {
            useUniqueModuleNames = true
        }

        jvm {
            kotlinJvmTarget = JavaVersion.VERSION_1_8
            compileSourceCompatibility = JavaVersion.VERSION_1_8
            compileTargetCompatibility = JavaVersion.VERSION_1_8
        }

        js()

        @OptIn(ExperimentalWasmDsl::class)
        wasmJs {
            target {
                browser()
                nodejs()
            }
        }

        @OptIn(ExperimentalWasmDsl::class)
        wasmWasi {
            target {
                nodejs()
            }
        }

        androidNativeAll()

        iosAll()
        macosAll()
        tvosAll()
        watchosAll()

        linuxAll()
        mingwAll()

        common {
            sourceSetMain {
                dependencies {
                    implementation(kotlincrypto.bitops.bits)
                    implementation(kotlincrypto.bitops.endian)

                    implementation(kotlincrypto.core.core)
                    implementation(kotlincrypto.core.digest)
                    implementation(kotlincrypto.core.mac)
                    implementation(kotlincrypto.core.xof)

                    implementation(kotlincrypto.error.error)

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

                    implementation(kotlincrypto.sponges.keccak)
                }
            }
        }
    }
}
