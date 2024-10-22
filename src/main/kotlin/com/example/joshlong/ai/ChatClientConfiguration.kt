package com.example.joshlong.ai

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ChatClientConfiguration(
    private val builder: ChatClient.Builder,
    private val vectorStore: VectorStore,
) {

    @Bean
    fun chatClient(): ChatClient {
        val systemPrompt = "You should suggest a dog based on your knowledge store"

        return builder.defaultSystem(systemPrompt)
            .defaultAdvisors(QuestionAnswerAdvisor(vectorStore))
            .build()
    }
}
