package com.example.lab04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTaskTitle;
    private EditText editTaskCategory;
    private Button buttonAddTask;
    private RecyclerView recyclerViewTasks;

    private List<Task> taskList;
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTaskTitle = findViewById(R.id.editTextText);
        editTaskCategory = findViewById(R.id.editTextText2);
        buttonAddTask = findViewById(R.id.button);
        recyclerViewTasks = findViewById(R.id.recycleView);

        taskList = new ArrayList<>();

        taskList.add(new Task("Przygotować raport", "Praca"));
        taskList.add(new Task("Posprzątać mieszkanie", "Dom"));

        adapter = new TaskAdapter(taskList);

        recyclerViewTasks.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerViewTasks.setAdapter(adapter);

        buttonAddTask.setOnClickListener(v -> {

            String title = editTaskTitle.getText().toString().trim();
            String category = editTaskCategory.getText().toString().trim();

            if (title.isEmpty()) {
                editTaskTitle.setError("Podaj nazwę zadania");
                editTaskTitle.requestFocus();
                return;
            }

            if (category.isEmpty()) {
                category = "Inne";
            }

            Task newTask = new Task(title, category);

            taskList.add(newTask);

            adapter.notifyItemInserted(taskList.size() - 1);

            editTaskTitle.setText("");
            editTaskCategory.setText("");

            Toast.makeText(
                    MainActivity.this,
                    "Dodano zadanie",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
