package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.common.MessageUtil;
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

            int squareSize = 10;

            String styling = MessageUtil.format(
                    "-fx-pref-width: {0}px;-fx-pref-height: {1}px;", squareSize, squareSize);

            switch (region.getRegionTypeName()) {

                case PLAIN:
                    styling += "-fx-background-color: #41980a;";
                    break;

                case FOREST:
                    styling += "-fx-background-color: #136d15;";
                    break;

                case WATER:
                    styling += "-fx-background-color: #009cf9;";
                    break;

                case MOUNTAIN:
                    styling += "-fx-background-color: #35424A;";
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

        loadWorld(generator.generateWorld("Test World", 50));
    }
}