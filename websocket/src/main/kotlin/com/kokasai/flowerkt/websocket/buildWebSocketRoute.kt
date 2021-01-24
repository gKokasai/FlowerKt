package com.kokasai.flowerkt.websocket

import com.kokasai.flowerkt.route.buildRoute
import io.ktor.util.pipeline.ContextDsl
import io.ktor.websocket.DefaultWebSocketServerSession
import io.ktor.websocket.webSocket

@ContextDsl
fun buildWebSocketRoute(handler: suspend DefaultWebSocketServerSession.() -> Unit) = buildRoute { webSocket(null, handler) }
