package com.example.joshlong

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<JoshlongSpringDemoKotlinApplication>().with(TestcontainersConfiguration::class).run(*args)
}
