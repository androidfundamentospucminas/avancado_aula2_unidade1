package com.walker.aula2modulo1androidavancado

class TaskPresenter(
    private val view: TaskContract.View
): TaskContract.Presenter {

    private val tasks = mutableListOf<TaskModel>()

    init {
        tasks.add(TaskModel("Tarefa 1", "Descricao da Tarefa 1", true))
        tasks.add(TaskModel("Tarefa 2", "Descricao da Tarefa 2", true))
        tasks.add(TaskModel("Tarefa 3", "Descricao da Tarefa 3", false))
        view.showTasks(tasks)
    }

    override fun getTasks() {
        view.showTasks(tasks)
    }

    override fun addTask(task: TaskModel) {
        task.id = tasks.size
        tasks.add(task)
        view.showTasks(tasks)
    }

    override fun updateTask(position: Int) {
        tasks[position].isCompleted = !tasks[position].isCompleted
        view.showTasks(tasks)
    }

    override fun deleteTask(task: TaskModel) {
        tasks.remove(task)
        view.showTasks(tasks)
    }
}