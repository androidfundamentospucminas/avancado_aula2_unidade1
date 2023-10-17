package com.walker.aula2modulo1androidavancado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.walker.aula2modulo1androidavancado.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskContract.View {

    private lateinit var presenter: TaskContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        presenter = TaskPresenter(this)

        binding.addTaskButton.setOnClickListener {
            // Adiciona nova tarefa
            val newTask = TaskModel("Nova Tarefa", "Descricao da Nova Tarefa", false)
            presenter.addTask(newTask)
        }

    }

    override fun showTasks(tasks: List<TaskModel>) {
        val adapter = TaskAdapter(this, tasks)
        binding.tasksList.adapter = adapter

        binding.tasksList.setOnItemLongClickListener { _, _, position, _ ->
            // Executa delete
            presenter.deleteTask(tasks[position])
            true
        }

        binding.tasksList.setOnItemClickListener { _, _, position, _ ->
            // Executa atualização do isCompleted (checked)
            presenter.updateTask(position)
        }
    }
}