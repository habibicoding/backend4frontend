package com.example.backend4frontend.service

import com.example.backend4frontend.data.TaskStatus
import com.example.backend4frontend.data.dto.TaskCreateDto
import com.example.backend4frontend.data.dto.TaskFetchDto
import com.example.backend4frontend.data.dto.TaskUpdateDto


interface TaskService {

    fun getTasks(status: TaskStatus?): Set<TaskFetchDto>

    fun getTaskById(id: Long): TaskFetchDto

    fun createTask(createRequest: TaskCreateDto): TaskFetchDto

    fun updateTask(id: Long, updateRequest: TaskUpdateDto): TaskFetchDto

    fun deleteTask(id: Long): String
}