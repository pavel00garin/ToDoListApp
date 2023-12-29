// module-info.java
module com.todolistapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.todolistapp to javafx.fxml;

    exports com.todolistapp;
}
