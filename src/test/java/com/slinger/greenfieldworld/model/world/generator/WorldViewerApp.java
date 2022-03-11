package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class WorldViewerApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        WorldGenerator generator = new WorldGenerator();
        World world = generator.generateWorld("Demo World", 10);

        URL resource = getClass().getResource("WorldViewer.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        WorldViewerController controller = fxmlLoader.getController();

        controller.loadWorld(world);

        primaryStage.setTitle("Green Field World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}