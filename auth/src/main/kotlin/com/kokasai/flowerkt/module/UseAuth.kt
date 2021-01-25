package com.kokasai.flowerkt.module

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication

interface UseAuth : InstallKtorProcess {
    val authenticationConfiguration: Authentication.Configuration.() -> Unit

    override fun installKtor(application: Application) {
        application.install(Authentication, authenticationConfiguration)
    }
}
