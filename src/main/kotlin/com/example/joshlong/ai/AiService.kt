package com.example.joshlong.ai

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.SearchRequest
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.stereotype.Service

@Service
class AiService(
    private val vectorStore: VectorStore,
    private val chatClient: ChatClient,
) {

    fun similaritySearch(query: String): MutableList<Document>? {
        return vectorStore.similaritySearch(SearchRequest.query(query).withTopK(2))
    }

    fun similaritySearchFromChatClient(query: String): String? {
        return chatClient.prompt()
            .user(query)
            .call()
            .content()
    }
}