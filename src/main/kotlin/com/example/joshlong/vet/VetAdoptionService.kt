package com.example.joshlong.vet

import com.example.joshlong.dog.internal.DogAdoptionEvent
import com.example.joshlong.dog.internal.DogDetail
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Service

@Service
class VetAdoptionService {

    @ApplicationModuleListener
    fun checkUp(dogAdoptionEvent: DogAdoptionEvent) {
        println("Vet: check dog status, dogId: ${dogAdoptionEvent.dogId}")
        println("Vet: In Progress...")
        println("Vet: done!")

        println("Vet: use internal class in dog package which makes test failure")
        val dogDetail = DogDetail(data = "something")
        println(dogDetail)
    }
}
