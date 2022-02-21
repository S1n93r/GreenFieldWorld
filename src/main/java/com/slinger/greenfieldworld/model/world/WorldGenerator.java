package com.slinger.greenfieldworld.model.world;

import java.util.Map;

public class WorldGenerator {

    private static int DEFAULT_GRID_SIZE = 16;

    public void generateInitialCluster(World world) {
        generateClusterAtCoordinate(world, new Coordinate(0, 0));
    }

    public void generateClusterToNorth(World world, Cluster exitCluster) {

        int x = exitCluster.getCoordinate().getX();
        int y = exitCluster.getCoordinate().getY() - 1;

        Cluster cluster = Cluster.builder().coordinate(new Coordinate(x, y)).build();

        world.addCluster(cluster);
    }

    public void generateClusterToEast(World world, Cluster exitCluster) {

        int x = exitCluster.getCoordinate().getX() + 1;
        int y = exitCluster.getCoordinate().getY();

        Cluster cluster = Cluster.builder().coordinate(new Coordinate(x, y)).build();

        world.addCluster(cluster);
    }

    public void generateClusterToSouth(World world, Cluster exitCluster) {

        int x = exitCluster.getCoordinate().getX();
        int y = exitCluster.getCoordinate().getY() + 1;

        Cluster cluster = Cluster.builder().coordinate(new Coordinate(x, y)).build();

        world.addCluster(cluster);
    }

    public void generateClusterToWest(World world, Cluster exitCluster) {

        int x = exitCluster.getCoordinate().getX() - 1;
        int y = exitCluster.getCoordinate().getY();

        Cluster cluster = Cluster.builder().coordinate(new Coordinate(x, y)).build();

        world.addCluster(cluster);
    }

    private void generateClusterAtCoordinate(World world, Coordinate coordinate) {

        Cluster cluster = Cluster.builder().coordinate(coordinate).build();

        generateRegions(world, cluster);

        world.addCluster(cluster);
    }

    private void generateRegions(World world, Cluster cluster) {

        Map<Coordinate, Region> regionMap = cluster.getUnmodifiableRegionsMap();

        int gridSize = world.getGridSize();

        int numberOfCoordinates = gridSize * gridSize;

        int x;
        int y;

        /* TODO: Use continuous coordinates instead of starting from 0/0 within every cluster? */
        for (int i = 0; i < numberOfCoordinates; i++) {

            x = i % gridSize;
            y = i / gridSize;

            int regionId = regionMap.size() + 1;

            /* TODO: RegionName.PLAINS should be given by default in Plains class. */
            Plains plains = Plains.builder().id(regionId).regionName(RegionName.PLAINS).build();

            cluster.addRegion(new Coordinate(x, y), plains);
        }
    }
}