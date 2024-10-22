package com.example.dog

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DogAdoptionController(
    private val dogAdoptionService: DogAdoptionService,
) {

    @PostMapping("/dogs/{dogId}/adoption")
    fun adopt(
        @PathVariable dogId: Long,
        @RequestParam owner: String,
    ) {
        dogAdoptionService.adopt(dogId, owner)
    }
}
