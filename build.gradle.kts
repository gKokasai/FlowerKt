plugins {
    id(GradlePlugin.kotlin_jvm) version Version.kotlin
}

group = Project.group
version = Project.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(Libraries.Kotlin.stdlib)
}
