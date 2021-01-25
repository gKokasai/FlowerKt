import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    id(GradlePlugin.kotlin_jvm) version Version.kotlin
    id(GradlePlugin.ktlint_gradle) version Version.ktlint_gradle
    id("maven-publishing") apply false
}

allprojects {
    apply(plugin = GradlePlugin.ktlint_gradle)

    repositories {
        mavenCentral()
    }

    configure<KtlintExtension> {
        version.set(Version.ktlint)
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "maven-publishing")

    group = Project.group
    version = Project.version

    repositories {
        jcenter()
    }

    dependencies {
        implementation(Libraries.Kotlin.stdlib)
    }
}
