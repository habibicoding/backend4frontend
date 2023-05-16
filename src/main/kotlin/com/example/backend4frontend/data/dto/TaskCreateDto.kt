package com.example.backend4frontend.data.dto

import com.example.backend4frontend.data.Priority
import jakarta.validation.constraints.Size


const val MIN_DESCRIPTION_LENGTH: Int = 3
const val MAX_DESCRIPTION_LENGTH: Int = 255

data class TaskCreateDto(
    @Size(min = MIN_DESCRIPTION_LENGTH, max = MAX_DESCRIPTION_LENGTH)
    val description: String,

    val isReminderSet: Boolean,

    val isTaskOpen: Boolean,

    val priority: Priority
)
