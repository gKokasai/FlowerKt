package com.kokasai.flowerkt.route

import io.ktor.auth.authenticate

fun buildAuthenticateRoute(
    vararg configurations: String? = arrayOf(null),
    optional: Boolean = false,
    build: RouteAction
) = buildRoute { authenticate(*configurations, optional = optional, build = build) }
