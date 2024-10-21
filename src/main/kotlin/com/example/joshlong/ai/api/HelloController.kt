package com.example.joshlong.ai.api

import com.example.joshlong.ai.service.HelloService
import org.springframework.ai.document.Document
import org.springframework.ai.embedding.EmbeddingModel
import org.springframework.ai.embedding.EmbeddingResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService,
    private val embeddingModel: EmbeddingModel,
) {

    @GetMapping("/hello")
    fun hello(@RequestParam query: String): MutableList<Document>? {
        return helloService.hello(query)
    }

    // https://docs.spring.io/spring-ai/reference/api/embeddings/ollama-embeddings.html
    @GetMapping("/ai/embedding")
    fun embed(
        @RequestParam(
            defaultValue = "Tell me a joke"
        ) message: String,
    ): Map<String, EmbeddingResponse> {
        val embeddingResponse: EmbeddingResponse = embeddingModel.embedForResponse(listOf(message))

        return mapOf("embedding" to embeddingResponse)
    }
}
