package com.example.ecommerceweb;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EcommerceWeb extends Application {
    UserInterface userInterface=new UserInterface();

    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(userInterface.createContent());
        stage.setTitle("EcommerceWeb");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}