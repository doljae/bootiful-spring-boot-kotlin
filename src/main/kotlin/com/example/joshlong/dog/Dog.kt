package com.example.joshlong.dog

import org.springframework.data.annotation.Id
import java.time.LocalDate

data class Dog(
    @Id
    val id: Long,
    val name: String,
    val description: String,
    val dob: LocalDate,
    val owner: String?,
)
