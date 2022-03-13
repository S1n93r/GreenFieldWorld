package com.slinger.greenfieldworld.model.world.generator;

import com.slinger.greenfieldworld.model.common.ColorPalettes;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.forest.ForestRegionName;
import com.slinger.greenfieldworld.model.world.regions.mountain.MountainRegionName;
import com.slinger.greenfieldworld.model.world.regions.plain.PlainRegionName;
import com.slinger.greenfieldworld.model.world.regions.water.WaterRegionName;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class WorldViewerController {

    private static final int MAP_SIZE = 500;

    @FXML
    private GridPane worldGrid;

    @FXML
    private TextField gridSideLengthInput;

    private void loadWorld(World world) {

        worldGrid.getChildren().clear();

        for (Region region : world.getUnmodifiableRegionMap().values()) {

            Coordinate coordinate = region.getCoordinate();

            HBox hBox = new HBox();

            String hexValue;

            switch (region.getRegionTypeName()) {

                case PLAIN:
                    if (region.getRegionName().equals(PlainRegionName.TALL_GRASS.name())
                            || region.getRegionName().equals(PlainRegionName.FLOWER_BED.name()))
                        hexValue = ColorPalettes.GREEN_LIGHTEST.getHexValue();
                    else
                        hexValue = ColorPalettes.GREEN_LIGHT.getHexValue();
                    break;

                case FOREST:
                    if (region.getRegionName().equals(ForestRegionName.GLADE.name()))
                        hexValue = ColorPalettes.GREEN_DARK.getHexValue();
                    else
                        hexValue = ColorPalettes.GREEN_DARKEST.getHexValue();
                    break;

                case WATER:
                    if (region.getRegionName().equals(WaterRegionName.LAKE.name())
                            || region.getRegionName().equals(WaterRegionName.RIVER.name()))
                        hexValue = ColorPalettes.BLUE.getHexValue();
                    else
                        hexValue = ColorPalettes.BLUE_DARK.getHexValue();
                    break;

                case MOUNTAIN:
                    if (region.getRegionName().equals(MountainRegionName.FOOTHILLS.name()))
                        hexValue = ColorPalettes.STONE_WALL_E.getHexValue();
                    else
                        hexValue = ColorPalettes.STONE_WALL_DARK.getHexValue();
                    break;

                case EMPTY:
                default:
                    throw new SwitchCaseNotDefinedException();
            }

            int squareSize = MAP_SIZE / world.getGridSideLength();

            String styling = MessageUtil.format(
                    "-fx-pref-width: {0}px;-fx-pref-height: {1}px; -fx-background-color: {2};",
                    squareSize, squareSize, hexValue);

            hBox.setStyle(styling);

            worldGrid.add(hBox, coordinate.getX(), coordinate.getY());
        }
    }

    @FXML
    private void generateWorld() {

        String gridSideLengthInput = this.gridSideLengthInput.getText();

        if (gridSideLengthInput.isBlank() || gridSideLengthInput.isEmpty()) {

            System.err.println(MessageUtil.format("Can't generate map. Grid side length can't be blank or 0."));

            return;
        }

        WorldGenerator generator = new WorldGenerator();

        if (gridSideLengthInput.replaceAll("[0-9]", "").length() == 0)
            loadWorld(generator.generateWorld("Test World", Integer.parseInt(gridSideLengthInput)));
        else
            System.err.println(MessageUtil.format("Can't generate map. Grid side length should only contain" +
                    " numbers."));
    }
}