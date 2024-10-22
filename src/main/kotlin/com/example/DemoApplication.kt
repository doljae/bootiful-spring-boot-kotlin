package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    val threads = Runtime.getRuntime().availableProcessors().toString()
    mapOf(
        "server.tomcat.threads.max" to threads,
        "jdk.virtualThreadScheduler.maxPoolSize" to threads
    ).forEach(System::setProperty)

    runApplication<DemoApplication>(*args)
}
