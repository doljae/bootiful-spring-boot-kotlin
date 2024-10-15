package com.example.joshlong.api

import com.example.joshlong.service.HelloService
import org.springframework.ai.document.Document
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService,
) {

    @GetMapping("/hello")
    fun hello(@RequestParam query: String): MutableList<Document>? {
        return helloService.hello(query)
    }
}
