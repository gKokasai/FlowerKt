plugins {
    id(GradlePlugin.kotlin_jvm) version Version.kotlin
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")

    group = Project.group
    version = Project.version

    repositories {
        jcenter()
    }

    dependencies {
        implementation(Libraries.Kotlin.stdlib)
    }
}
