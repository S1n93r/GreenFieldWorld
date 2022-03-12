package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import com.slinger.greenfieldworld.model.world.regions.Region;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class WorldViewerController {

    @FXML
    private GridPane worldGrid;

    private void loadWorld(World world) {

        worldGrid.getChildren().clear();

        for (Region region : world.getUnmodifiableRegionMap().values()) {

            Coordinate coordinate = region.getCoordinate();

            HBox hBox = new HBox();

            String styling = "-fx-pref-width: 24px;-fx-pref-height: 24px;";

            switch (region.getRegionTypeName()) {

                case PLAIN:
                    styling += "-fx-background-color: yellow;";
                    break;

                case FOREST:
                    styling += "-fx-background-color: green;";
                    break;

                case WATER:
                    styling += "-fx-background-color: blue;";
                    break;

                case MOUNTAIN:
                    styling += "-fx-background-color: gray;";
                    break;

                case EMPTY:
                default:
            }

            hBox.setStyle(styling);

            worldGrid.add(hBox, coordinate.getX(), coordinate.getY());
        }
    }

    @FXML
    private void generateWorld() {

        WorldGenerator generator = new WorldGenerator();

        loadWorld(generator.generateWorld("Test World", 20));
    }
}