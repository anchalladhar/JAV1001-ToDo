package com.example.todoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Added Button connection
    private lateinit var editTextTask: EditText
    private lateinit var buttonAddTask: Button
    private lateinit var listViewTasks: ListView
    // Added variable to store input from user
    private lateinit var tasks: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI components
        editTextTask = findViewById(R.id.editTextTask)
        buttonAddTask = findViewById(R.id.buttonAddTask)
        listViewTasks = findViewById(R.id.listViewTasks)

        // Initialize task list and adapter
        tasks = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_checked, tasks)

        // Set the adapter for the ListView and enable multiple choice mode
        listViewTasks.adapter = adapter
        listViewTasks.choiceMode = ListView.CHOICE_MODE_MULTIPLE



    private fun addTask() {
        // Get the task text from the EditText and trim any leading/trailing whitespace
        val task = editTextTask.text.toString().trim()
        if (task.isNotEmpty()) {
            // Add the task to the list, update the adapter, and clear the EditText
            tasks.add(task)
            adapter.notifyDataSetChanged()
            editTextTask.text.clear()
        }
    }
}
