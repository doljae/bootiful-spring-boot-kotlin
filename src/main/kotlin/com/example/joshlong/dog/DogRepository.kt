package com.example.joshlong.dog

import org.springframework.data.repository.ListCrudRepository

interface DogRepository : ListCrudRepository<Dog, Long>
