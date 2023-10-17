package com.walker.aula2modulo1androidavancado

data class TaskModel(
    var title: String,
    var description: String,
    var isCompleted: Boolean,
    var id: Int? = null
)