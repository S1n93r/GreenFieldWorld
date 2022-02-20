package com.slinger.greenfieldworld.model.world;

import java.util.Map;

public class RegionsGenerator {

    private static int DEFAULT_GRID_SIZE = 16;

    public void generateInitialRegions(World world) {
        generateInitialRegions(world, DEFAULT_GRID_SIZE);
    }

    public void generateInitialRegions(World world, int gridSize) {

        Map<Coordinate, Region> regionMap = world.getUnmodifiableRegionsMap();

        int numberOfCoordinates = gridSize * gridSize;

        int x = 0;
        int y = 0;

        for (int i = 0; i < numberOfCoordinates; i++) {

            x = i % gridSize;
            y = i / gridSize;

            int regionId = regionMap.size() + 1;

            /* TODO: RegionName.PLAINS should be given by default in Plains class. */
            Plains plains = Plains.builder().id(regionId).regionName(RegionName.PLAINS).build();

            world.addRegion(new Coordinate(x, y), plains);
        }
    }

    public void generateRegionsToNorth(World world) {

    }

    public void generateRegionsToEast(World world) {

    }

    public void generateRegionsToSouth(World world) {

    }

    public void generateRegionsToWest(World world) {

    }
}