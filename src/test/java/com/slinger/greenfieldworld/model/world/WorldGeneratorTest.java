package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WorldGeneratorTest {

    private final WorldGenerator sut = new WorldGenerator();

    @Test
    public void afterGeneratingClusterMapIsNotEmpty() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        /* When */
        sut.generateCluster(world);

        /* Then */
        assertFalse(world.getUnmodifiableClusterMap().isEmpty());
    }

    @Test
    public void initializedCenterClusterFitsGridSize() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        /* When */
        sut.generateCluster(world);

        /* Then */
        Cluster actualCluster = world.getUnmodifiableClusterMap().get(new Coordinate(2, 2));

        assertEquals(9, actualCluster.getUnmodifiableRegionsMap().size());
    }

    @Test
    public void initializedCenterClusterHasCorrectRegions() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        /* When */
        sut.generateCluster(world);

        /* Then */
        Cluster actualCluster = world.getUnmodifiableClusterMap().get(new Coordinate(2, 2));

        assertEquals(RegionName.PLAINS,
                actualCluster.getUnmodifiableRegionsMap().get(new Coordinate(6, 6)).getRegionName());
        assertEquals(RegionName.PLAINS,
                actualCluster.getUnmodifiableRegionsMap().get(new Coordinate(7, 7)).getRegionName());
        assertEquals(RegionName.PLAINS,
                actualCluster.getUnmodifiableRegionsMap().get(new Coordinate(8, 8)).getRegionName());
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheNorth() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        sut.generateCluster(world);

        Cluster centerCluster = world.getUnmodifiableClusterMap().get(new Coordinate(2, 2));

        /* When */
        sut.generateClusterToNorth(world, centerCluster);

        /* Then */
        Cluster clusterNorthFromCenter = world.getCluster(new Coordinate(2, 1));

        assertEquals(9, clusterNorthFromCenter.getUnmodifiableRegionsMap().size());
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheEast() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        sut.generateCluster(world);

        Cluster centerCluster = world.getUnmodifiableClusterMap().get(new Coordinate(2, 2));

        /* When */
        sut.generateClusterToEast(world, centerCluster);

        /* Then */
        Cluster clusterEastFromCenter = world.getCluster(new Coordinate(3, 2));

        assertEquals(9, clusterEastFromCenter.getUnmodifiableRegionsMap().size());
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheSouth() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        sut.generateCluster(world);

        Cluster centerCluster = world.getUnmodifiableClusterMap().get(new Coordinate(2, 2));

        /* When */
        sut.generateClusterToSouth(world, centerCluster);

        /* Then */
        Cluster clusterSouthFromCenter = world.getCluster(new Coordinate(2, 3));

        assertEquals(9, clusterSouthFromCenter.getUnmodifiableRegionsMap().size());
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheWest() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        sut.generateCluster(world);

        Cluster centerCluster = world.getUnmodifiableClusterMap().get(new Coordinate(2, 2));

        /* When */
        sut.generateClusterToWest(world, centerCluster);

        /* Then */
        Cluster clusterWestFromCenter = world.getCluster(new Coordinate(1, 2));

        assertEquals(9, clusterWestFromCenter.getUnmodifiableRegionsMap().size());
    }
}