package com.example.joshlong.dog

import com.example.joshlong.dog.internal.DogAdoptionEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DogAdoptionService(
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val dogRepository: DogRepository,
) {

    @Transactional
    fun adopt(dogId: Long, owner: String) {
        val dog = dogRepository.findByIdOrNull(dogId)
            ?: throw RuntimeException("Dog with id: $dogId not found")

        val dogWithOwner = dog.copy(owner = owner)

        dogRepository.save(dogWithOwner)

        applicationEventPublisher.publishEvent(DogAdoptionEvent(dogId = dogWithOwner.id))
    }
}
