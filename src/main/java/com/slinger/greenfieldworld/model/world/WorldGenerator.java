package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.common.DiceUtil;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.mountain.Foothills;
import com.slinger.greenfieldworld.model.world.regions.plain.FlowerBed;
import com.slinger.greenfieldworld.model.world.regions.plain.TallGrass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldGenerator {

    private static final int DEFAULT_REGION_GRID_SIDE_LENGTH = 5;

    /* TODO: Make map size dependant instead of fix */
    private final static int MAX_MOUNTAINS = 4;
    private final static int MAX_MOUNTAIN_SIZE = 7;

    public World generateWorld(String name) {
        return generateWorld(name, DEFAULT_REGION_GRID_SIDE_LENGTH);
    }

    public World generateWorld(String name, int gridSideLength) {

        World world = World.builder().name(name).gridSideLength(gridSideLength).build();

        generateRegions(world);

        return world;
    }

    private Map<Coordinate, Region> generateRegions(World world) {

        generatePlains(world);
        addMountains(world);

        return new HashMap<>();
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

        int numberOfMountains = DiceUtil.rollDice(MAX_MOUNTAINS);

        for (int i = 0; i < numberOfMountains; i++) {
            addMountain(world);
        }
    }

    private void addMountain(World world) {

        int gridSideLength = world.getGridSideLength();

        int mountainSize = DiceUtil.rollDice(MAX_MOUNTAIN_SIZE);

        int mountainUpperLeftX = DiceUtil.rollDice(gridSideLength) - 1;
        int mountainUpperLeftY = DiceUtil.rollDice(gridSideLength) - 1;

        List<Coordinate> coordinateList = new ArrayList<>();

        List<Coordinate> xCoordinateList = new ArrayList<>();

        for (int i = 0; i < mountainSize; i++) {

            Coordinate coordinate = Coordinate.of(mountainUpperLeftX + i, mountainUpperLeftY);

            xCoordinateList.add(coordinate);
            coordinateList.add(coordinate);
        }

        for (int i = 1; i < mountainSize; i++)
            for (Coordinate coordinate : xCoordinateList)
                coordinateList.add(Coordinate.of(coordinate.getX(), coordinate.getY() + i));

        for (Coordinate coordinate : coordinateList)
            if (world.getUnmodifiableRegionMap().containsKey(coordinate))
                world.addRegion(new Foothills(coordinate));
    }
}