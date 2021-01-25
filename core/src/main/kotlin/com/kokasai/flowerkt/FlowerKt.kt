package com.kokasai.flowerkt

import com.kokasai.flowerkt.module.InstallKtorProcess
import com.kokasai.flowerkt.module.LaunchProcess
import com.kokasai.flowerkt.route.RouteBuilder
import io.ktor.application.Application
import io.ktor.routing.routing
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.ApplicationEngineFactory
import io.ktor.server.engine.embeddedServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface FlowerKt : LaunchProcess, InstallKtorProcess {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger("FlowerKt")
    }

    /**
     * サーバーのポート番号です
     */
    val port: Int

    /**
     * ルートビルダーでルートの登録をします
     */
    val routeBuilder: RouteBuilder

    /**
     * サーバーのエンジン
     */
    val engine: ApplicationEngineFactory<ApplicationEngine, ApplicationEngine.Configuration>

    /**
     * Application::install を実行します
     *
     * installKtor の実行順は継承側で定義する必要があります
     * ```
     * override fun Application.installKtor() {
     *     super<Use#A>.installKtor()
     *     super<Use#B>.installKtor()
     * }
     * ```
     */
    override fun Application.installKtor() {}

    /**
     * サーバーを起動します
     *
     * `main` 関数でこの関数を呼び出してください
     */
    override fun launch() {
        embeddedServer(engine, port) {
            installKtor()
            routing {
                routeBuilder.build(this)
            }
        }.start()
    }
}
