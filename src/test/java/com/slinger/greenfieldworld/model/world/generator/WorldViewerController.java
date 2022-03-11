package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import com.slinger.greenfieldworld.model.world.regions.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WorldViewerController {

    @FXML
    private GridPane worldGrid;

    @FXML
    private Button generateWorld;

    private void loadWorld(World world) {

        worldGrid.getChildren().clear();

        for (Region region : world.getUnmodifiableRegionMap().values()) {

            Coordinate coordinate = region.getCoordinate();

            Label label = new Label(region.getRegionTypeName().name().substring(0, 1));

            label.setStyle("-fx-padding: 4px 8px");

            worldGrid.add(label, coordinate.getX(), coordinate.getY());
        }
    }

    @FXML
    private void generateWorld() {

        WorldGenerator generator = new WorldGenerator();

        loadWorld(generator.generateWorld("Test World", 10));
    }
}