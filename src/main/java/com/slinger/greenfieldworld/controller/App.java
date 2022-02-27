package com.slinger.greenfieldworld.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL resource = getClass().getResource("root.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        primaryStage.setTitle("Green Field World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}