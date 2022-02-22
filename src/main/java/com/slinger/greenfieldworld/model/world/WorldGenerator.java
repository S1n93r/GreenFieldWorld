package com.slinger.greenfieldworld.model.world;

public class WorldGenerator {

    public void generateCluster(World world) {

        int clusterGridSideLength = world.getClusterGridSideLength();

        int numberOfCoordinates = clusterGridSideLength * clusterGridSideLength;

        /* TODO: Use continuous coordinates instead of starting from 0/0 within every cluster? */
        for (int i = 0; i < numberOfCoordinates; i++) {

            int x = i % clusterGridSideLength;
            int y = i / clusterGridSideLength;

            Cluster cluster = Cluster.builder().coordinate(new Coordinate(x, y)).build();

            world.addCluster(cluster);
        }

        Cluster centerCluster = world.getCluster(new Coordinate(2, 2));

        generateRegions(world, centerCluster);
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

    private void generateRegions(World world, Cluster cluster) {

        int regionGridSideLength = world.getRegionGridSideLength();

        int numberOfCoordinates = regionGridSideLength * regionGridSideLength;

        for (int i = 0; i < numberOfCoordinates; i++) {

            int x = i % regionGridSideLength;
            int y = i / regionGridSideLength;

            int xShift = cluster.getCoordinate().getX() * regionGridSideLength;
            int yShift = cluster.getCoordinate().getY() * regionGridSideLength;

            int xShifted = x + xShift;
            int yShifted = y + yShift;

            /* TODO: RegionName.PLAINS should be given by default in Plains class. */
            Plains plains = Plains.builder().coordinate(new Coordinate(xShifted, yShifted))
                    .regionName(RegionName.PLAINS).build();

            cluster.addRegion(plains);
        }
    }
}