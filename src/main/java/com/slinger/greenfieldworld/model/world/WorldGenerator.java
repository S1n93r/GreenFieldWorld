package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.common.DiceUtil;
import com.slinger.greenfieldworld.model.common.GeometricFormsUtil;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.forest.Glade;
import com.slinger.greenfieldworld.model.world.regions.mountain.Foothills;
import com.slinger.greenfieldworld.model.world.regions.plain.FlowerBed;
import com.slinger.greenfieldworld.model.world.regions.plain.TallGrass;
import com.slinger.greenfieldworld.model.world.regions.water.Lake;

import java.util.List;

public class WorldGenerator {

    private static final int DEFAULT_REGION_GRID_SIDE_LENGTH = 5;

    private final static int MAX_MOUNTAIN_NUMBER_RATIO = 15;
    private final static int MAX_MOUNTAIN_RADIUS_RATIO = 20;

    private final static int MAX_FOREST_NUMBER_RATIO = 50;
    private final static int MAX_FOREST_RADIUS_RATIO = 15;

    private final static int MAX_LAKE_NUMBER_RATIO = 5;
    private final static int MAX_LAKE_RADIUS_RATIO = 10;

    public World generateWorld(String name) {
        return generateWorld(name, DEFAULT_REGION_GRID_SIDE_LENGTH);
    }

    public World generateWorld(String name, int gridSideLength) {

        World world = World.builder().name(name).gridSideLength(gridSideLength).build();

        generateRegions(world);

        return world;
    }

    private void generateRegions(World world) {

        generatePlains(world);
        addLakes(world);
        addForests(world);
        addMountains(world);
    }

    private void generatePlains(World world) {

        int gridSideLength = world.getGridSideLength();

        int numberOfCoordinates = gridSideLength * gridSideLength;

        for (int i = 0; i < numberOfCoordinates; i++) {

            int x = i % gridSideLength;
            int y = i / gridSideLength;

            int regionDice = DiceUtil.rollDice(100);

            Region region = regionDice <= 15 ? new FlowerBed(Coordinate.of(x, y)) : new TallGrass(Coordinate.of(x, y));

            world.addRegion(region);
        }
    }

    private void addMountains(World world) {

        int maxNumberOfMountains = world.getGridSideLength() * MAX_MOUNTAIN_NUMBER_RATIO / 100;

        int numberOfMountains = DiceUtil.rollDice(maxNumberOfMountains);

        for (int i = 0; i < numberOfMountains; i++) {
            addMountain(world);
        }
    }

    private void addMountain(World world) {

        int gridSideLength = world.getGridSideLength();

        int maxMountainRadius = gridSideLength * MAX_MOUNTAIN_RADIUS_RATIO / 100;

        int mountainRadius = DiceUtil.rollDice(maxMountainRadius);

        int mountainCenterX = DiceUtil.rollDice(gridSideLength) - 1;
        int mountainCenterY = DiceUtil.rollDice(gridSideLength) - 1;

        List<Coordinate> coordinateList = GeometricFormsUtil.midPointAlgorithmDrawCircleFilled(
                mountainCenterX, mountainCenterY, mountainRadius);

        for (Coordinate coordinate : coordinateList)
            if (world.getUnmodifiableRegionMap().containsKey(coordinate))
                world.addRegion(new Foothills(coordinate));
    }

    /* TODO: If forest generation remains the same as for mountains, methods can be unified. */
    private void addForests(World world) {

        int maxNumberOfForests = world.getGridSideLength() * MAX_FOREST_NUMBER_RATIO / 100;

        int numberOfForests = DiceUtil.rollDice(maxNumberOfForests);

        for (int i = 0; i < numberOfForests; i++) {
            addForest(world);
        }
    }

    /* TODO: If forest generation remains the same as for mountains, methods can be unified. */
    private void addForest(World world) {

        int gridSideLength = world.getGridSideLength();

        int maxForestRadius = gridSideLength * MAX_FOREST_RADIUS_RATIO / 100;

        int forestRadius = DiceUtil.rollDice(maxForestRadius);

        int forestCenterX = DiceUtil.rollDice(gridSideLength) - 1;
        int forestCenterY = DiceUtil.rollDice(gridSideLength) - 1;

        List<Coordinate> coordinateList = GeometricFormsUtil.midPointAlgorithmDrawCircleFilled(
                forestCenterX, forestCenterY, forestRadius);

        for (Coordinate coordinate : coordinateList)
            if (world.getUnmodifiableRegionMap().containsKey(coordinate))
                world.addRegion(new Glade(coordinate));
    }

    /* TODO: If forest generation remains the same as for mountains, methods can be unified. */
    private void addLakes(World world) {

        int maxNumberOfLakes = world.getGridSideLength() * MAX_LAKE_NUMBER_RATIO / 100;

        int numberOfLakes = DiceUtil.rollDice(maxNumberOfLakes);

        for (int i = 0; i < numberOfLakes; i++) {
            addLake(world);
        }
    }

    /* TODO: If forest generation remains the same as for mountains, methods can be unified. */
    private void addLake(World world) {

        int gridSideLength = world.getGridSideLength();

        int maxLakeRadius = gridSideLength * MAX_LAKE_RADIUS_RATIO / 100;

        int lakeRadius = DiceUtil.rollDice(maxLakeRadius);

        int lakeCenterX = DiceUtil.rollDice(gridSideLength) - 1;
        int lakeCenterY = DiceUtil.rollDice(gridSideLength) - 1;

        List<Coordinate> coordinateList = GeometricFormsUtil.midPointAlgorithmDrawCircleFilled(
                lakeCenterX, lakeCenterY, lakeRadius);

        for (Coordinate coordinate : coordinateList)
            if (world.getUnmodifiableRegionMap().containsKey(coordinate))
                world.addRegion(new Lake(coordinate));
    }
}