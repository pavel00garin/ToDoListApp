package com.todolistapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ToDoListController controller = new ToDoListController();
        controller.start(primaryStage);
    }
}

