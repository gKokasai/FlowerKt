package com.kokasai.flowerkt.module

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.websocket.WebSockets

interface UseWebsocket : InstallKtorProcess {
    val webSocketsOptions: WebSockets.WebSocketOptions.() -> Unit

    override fun Application.installKtor() {
        install(WebSockets, webSocketsOptions)
    }
}
