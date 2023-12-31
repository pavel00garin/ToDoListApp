package com.todolistapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToDoListController {

    @FXML
    private TextField taskInput;

    @FXML
    private ListView<String> taskList;

    @FXML
    private void initialize() {

    }

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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ToDoList.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("ToDo List App");
        stage.show();
    }

    @FXML
    void loadTasks() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Tasks");
        File file = fileChooser.showOpenDialog(new Stage());

        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                List<String> loadedTasks = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    loadedTasks.add(line);
                }
                tasks.clear();
                tasks.addAll(loadedTasks);
                taskList.setItems(tasks);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    @FXML
    private void saveTasks() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Tasks");
        File file = fileChooser.showSaveDialog(new Stage());

        if (file != null) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (String task : tasks) {
                    writer.println(task);
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}

