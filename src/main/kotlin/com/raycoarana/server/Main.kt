package com.raycoarana.server

import reactor.core.publisher.Mono
import reactor.netty.http.HttpProtocol
import reactor.netty.http.client.HttpClient
import reactor.netty.http.server.HttpServer
import java.time.Duration

fun main() {
    val server = HttpServer.create()
        .protocol(HttpProtocol.HTTP11, HttpProtocol.H2C)
        .idleTimeout(Duration.ofSeconds(5))
        .port(0)
        .route { routes ->
            routes.get("/test/{param}") { request, response ->
                response.sendString(request.receive()
                    .asString()
                    .map { s -> s + ' ' + request.param("param") + '!' }
                    .log("http-server"))
            }
        }
        .bindNow()

    val response = HttpClient.create()
        .protocol(HttpProtocol.H2C)
        .get()
        .uri("http://localhost:${server.port()}/test/hello-world")
        .responseSingle { res, bytes ->
            bytes.asString().zipWith(Mono.just(res.responseHeaders()))
        }
        .block()

    println(response)
}
