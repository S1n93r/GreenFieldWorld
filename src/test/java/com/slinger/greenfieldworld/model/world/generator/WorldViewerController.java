package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import com.slinger.greenfieldworld.model.world.regions.Region;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class WorldViewerController {

    private static final String STYLE_CLASS_PLAIN_TILE = "region-tile-plain";
    private static final String STYLE_CLASS_FOREST_TILE = "region-tile-forest";
    private static final String STYLE_CLASS_WATER_TILE = "region-tile-water";
    private static final String STYLE_CLASS_MOUNTAIN_TILE = "region-tile-mountain";

    @FXML
    private GridPane worldGrid;

    private void loadWorld(World world) {

        worldGrid.getChildren().clear();

        for (Region region : world.getUnmodifiableRegionMap().values()) {

            Coordinate coordinate = region.getCoordinate();

            HBox hBox = new HBox();

            switch (region.getRegionTypeName()) {

                case PLAIN:
                    hBox.getStyleClass().add(STYLE_CLASS_PLAIN_TILE);
                    break;

                case FOREST:
                    hBox.getStyleClass().add(STYLE_CLASS_FOREST_TILE);
                    break;

                case WATER:
                    hBox.getStyleClass().add(STYLE_CLASS_WATER_TILE);
                    break;

                case MOUNTAIN:
                    hBox.getStyleClass().add(STYLE_CLASS_MOUNTAIN_TILE);
                    break;

                case EMPTY:
                default:
            }

            worldGrid.add(hBox, coordinate.getX(), coordinate.getY());
        }
    }

    @FXML
    private void generateWorld() {

        WorldGenerator generator = new WorldGenerator();

        loadWorld(generator.generateWorld("Test World", 20));
    }
}