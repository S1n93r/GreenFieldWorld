package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WorldViewerController {

    @FXML
    private GridPane worldGrid;

    public void loadWorld(World world) {

        for (Region region : world.getUnmodifiableRegionMap().values()) {

            Coordinate coordinate = region.getCoordinate();

            Label label = new Label(region.getRegionTypeName().name().substring(0, 1));

            label.setStyle("-fx-padding: 4px 8px");

            worldGrid.add(label, coordinate.getX(), coordinate.getY());
        }
    }
}