plugins {
    id("org.jetbrains.kotlin.js") version "1.4.10"
}

group = "org.sergiopipe"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://dl.bintray.com/subroh0508/maven")
    mavenCentral()
    jcenter()
}

dependencies {
    val kotlinWrapperVersion = "16.14.0-pre.125-kotlin-1.4.10"
    val reactVersion = "16.13.1"
    val materialUiWrapperVersion = "0.5.3"

    implementation(kotlin("stdlib-js"))
    //React + Wrappers
    implementation("org.jetbrains:kotlin-react:$kotlinWrapperVersion")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinWrapperVersion")
    implementation("org.jetbrains:kotlin-react-router-dom:5.1.2-pre.125-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-styled:5.2.0-pre.125-kotlin-1.4.10")
    implementation("net.subroh0508.kotlinmaterialui:core:$materialUiWrapperVersion")
    implementation("net.subroh0508.kotlinmaterialui:lab:$materialUiWrapperVersion")
    implementation(npm("react", reactVersion))
    implementation(npm("react-dom", reactVersion))
    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.0-M1")

}

kotlin {
    js {
        browser {
            webpackTask {
                cssSupport.enabled = true
            }                                                                                                                                  

            runTask {
                cssSupport.enabled = true
                cssSupport.mode
            }

            testTask {
                useKarma {
                    useChromeHeadless()
                    webpackConfig.cssSupport.enabled = true
                }
            }
        }
        binaries.executable()
    }
}