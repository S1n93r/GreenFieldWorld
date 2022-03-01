package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.world.events.BeggarAppears;
import com.slinger.greenfieldworld.model.world.regions.Plains;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class WorldGenerator {

    public World generateWorld(String name) {

        World world = World.builder().name(name).build();

        generateRegions(world);

        return world;
    }

    public World generateWorld(String name, int gridSideLength) {

        World world = World.builder().name(name).gridSideLength(gridSideLength).build();

        generateRegions(world);

        return world;
    }

    private void generateRegions(World world) {

        int clusterGridSideLength = world.getGridSideLength();

        int numberOfCoordinates = clusterGridSideLength * clusterGridSideLength;

        for (int i = 0; i < numberOfCoordinates; i++) {

            int x = i % clusterGridSideLength;
            int y = i / clusterGridSideLength;

            Region region = new Plains(Coordinate.of(x, y));

            region.addEvent(new BeggarAppears(25));

            world.addRegion(region);
        }
    }
}