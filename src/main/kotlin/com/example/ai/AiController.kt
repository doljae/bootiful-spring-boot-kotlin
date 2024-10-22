package com.example.ai

import org.springframework.ai.document.Document
import org.springframework.ai.embedding.EmbeddingModel
import org.springframework.ai.embedding.EmbeddingResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AiController(
    private val aiService: AiService,
    private val embeddingModel: EmbeddingModel,
) {

    @GetMapping("/similarity-search")
    fun similaritySearch(
        @RequestParam query: String,
        @RequestParam size: Int,
    ): MutableList<Document>? {
        return aiService.similaritySearch(query, size)
    }

    @GetMapping("/similarity-search/client")
    fun similaritySearchFromChatClient(
        @RequestParam query: String,
    ): String? {
        return aiService.similaritySearchFromChatClient(query)
    }

    // https://docs.spring.io/spring-ai/reference/api/embeddings/ollama-embeddings.html
    @GetMapping("/ai/embedding")
    fun embeddingResponse(
        @RequestParam(
            defaultValue = "Tell me a joke"
        ) message: String,
    ): Map<String, EmbeddingResponse> {
        val embeddingResponse: EmbeddingResponse = embeddingModel.embedForResponse(listOf(message))

        return mapOf("embedding" to embeddingResponse)
    }
}
