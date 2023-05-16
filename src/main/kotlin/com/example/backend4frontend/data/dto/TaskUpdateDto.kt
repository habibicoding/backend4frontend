package com.example.backend4frontend.data.dto

import com.example.backend4frontend.data.Priority

data class TaskUpdateDto(
    val description: String?,
    val isReminderSet: Boolean?,
    val isTaskOpen: Boolean?,
    val priority: Priority?
)
