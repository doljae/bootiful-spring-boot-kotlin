package com.example.joshlong.ai

import com.example.joshlong.dog.DogRepository
import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener


@Configuration
class VectorStoreInitializationConfiguration(
    private val vectorStore: VectorStore,
    private val dogRepository: DogRepository,
) {

    @EventListener(ApplicationStartedEvent::class)
    fun init() {
        val springRelatedDocuments = listOf(
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

        val dogRelatedDocuments = dogRepository.findAll()
            .map {
                Document(
                    "id: ${it.id}, name: ${it.name}, description: ${it.description}",
                    mapOf(
                        "dogId" to it.id,
                        "name" to it.name,
                        "description" to it.description,
                    )
                )
            }
            .toList()

        vectorStore.add(springRelatedDocuments)
        vectorStore.add(dogRelatedDocuments)
    }
}
