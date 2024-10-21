package com.example.joshlong.ai.service

import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.SearchRequest
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class HelloService(
    private val vectorStore: VectorStore,
) {

    fun hello(query: String): MutableList<Document>? {
        val documents = listOf(
            Document(
                "Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!",
                mapOf("meta1" to "meta1")
            ),
            Document("The World is Big and Salvation Lurks Around the Corner"),
            Document(
                "You walk forward facing the past and you turn back toward the future.",
                mapOf("meta2" to "meta2")
            ),
            Document("Hello World!"),
        )

        vectorStore.add(documents)

        return vectorStore.similaritySearch(SearchRequest.query(query).withTopK(2))
    }
}
