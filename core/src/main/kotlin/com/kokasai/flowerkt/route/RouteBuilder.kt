package com.kokasai.flowerkt.route

import io.ktor.application.ApplicationCall
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.util.pipeline.ContextDsl
import io.ktor.util.pipeline.PipelineInterceptor

typealias RouteAction = Route.() -> Unit

interface RouteBuilder {
    fun build(parent: Route)

    operator fun plus(other: RouteBuilder) = object : RouteBuilder {
        override fun build(parent: Route) {
            this@RouteBuilder.build(parent)
            other.build(parent)
        }
    }

    interface Container : RouteBuilder {
        val routes: Map<RoutePath, RouteBuilder>

        override fun build(parent: Route) {
            routes.forEach { (path, builder) ->
                parent.route(path.path) {
                    builder.build(this)
                }
            }
        }
    }

    class Element(val action: RouteAction) : RouteBuilder {
        override fun build(parent: Route) = parent.action()
    }
}

@ContextDsl
fun buildRoute(action: RouteAction) = RouteBuilder.Element(action)

@ContextDsl
fun buildGetRoute(body: PipelineInterceptor<Unit, ApplicationCall>) = buildRoute { get(body) }
