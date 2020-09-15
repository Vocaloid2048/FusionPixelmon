plugins {
    `kotlin-dsl`
    kotlin("jvm") version embeddedKotlinVersion
}

group = "me.fusiondev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}