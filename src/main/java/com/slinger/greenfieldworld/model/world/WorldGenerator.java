package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.common.DiceUtil;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.forest.Glade;
import com.slinger.greenfieldworld.model.world.regions.plain.FlowerBed;

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

            int dice = DiceUtil.rollDice(4);

            Region region = new Glade(Coordinate.of(x, y));

            if (dice == 4) {
                region = new FlowerBed(Coordinate.of(x, y));
            }

            world.addRegion(region);
        }
    }
}