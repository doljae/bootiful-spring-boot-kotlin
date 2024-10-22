package com.example.joshlong.vc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestClient

@RestController
class VCController(
    private val builder: RestClient.Builder,
) {

    private var restClient: RestClient = builder.build()

    @GetMapping("/vc")
    fun vc(@RequestParam delay: Int): String? {
        val response = restClient.get()
            .uri("https://httpbin.org/delay/$delay")
            .retrieve()

        return response.body(String::class.java)
    }
}
