package com.todolistapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDoList.fxml"));
        Parent root = loader.load();

        ToDoListController controller = loader.getController();
        controller.loadTasks();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.setTitle("ToDo List App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
