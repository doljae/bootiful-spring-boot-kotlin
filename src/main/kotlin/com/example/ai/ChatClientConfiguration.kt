package com.example.ai

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource

@Configuration
class ChatClientConfiguration(
    private val builder: ChatClient.Builder,
    private val vectorStore: VectorStore,
    @Value("classpath:/system.md")
    private val system: Resource,
) {

    @Bean
    fun chatClient(): ChatClient {
        return builder.defaultAdvisors(QuestionAnswerAdvisor(vectorStore))
            .defaultSystem(system)
            .build()
    }
}
