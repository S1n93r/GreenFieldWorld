package com.slinger.greenfieldworld.model.world;

public class WorldGenerator {

    public void generateRegions(World world) {

        int clusterGridSideLength = world.getRegionGridSideLength();

        int numberOfCoordinates = clusterGridSideLength * clusterGridSideLength;

        for (int i = 0; i < numberOfCoordinates; i++) {

            int x = i % clusterGridSideLength;
            int y = i / clusterGridSideLength;

            Region region = Plains.builder().coordinate(new Coordinate(x, y)).build();

            world.addRegion(region);
        }
    }
}