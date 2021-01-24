dependencies {
    api(project(":database-exposed"))
    api(project(":file"))
    implementation(Libraries.sqlite_driver)
}
