package com.example.backend4frontend.errorhandler

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ApiError(
    val message: String? = "Something went wrong",
    val status: HttpStatus,
    val code: Int = status.value(),
    val timestamp: LocalDateTime = LocalDateTime.now()
)