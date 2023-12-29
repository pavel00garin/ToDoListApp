package com.todolistapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ToDoListController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    private final ObservableList<String> tasks = FXCollections.observableArrayList();

    @FXML
    private void addTask() {
        String newTask = taskInput.getText();
        tasks.add(newTask);
        taskList.setItems(tasks);
        taskInput.clear();
    }

    @FXML
    private void removeTask() {
        int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tasks.remove(selectedIndex);
            taskList.setItems(tasks);
        }
    }

    @FXML
    private void markAsCompleted() {
        int selectedIndex = taskList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String selectedTask = tasks.get(selectedIndex);
            String completedTask = "[Completed] " + selectedTask;
            tasks.set(selectedIndex, completedTask);
            taskList.setItems(tasks);
        }
    }

    @FXML
    public void start(Stage stage) throws IOException {
        loadTasks(); // Load tasks when the app starts
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ToDoList.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("ToDo List App");
        stage.show();
    }

    private void loadTasks() {
    }
}
