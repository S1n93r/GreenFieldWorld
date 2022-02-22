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
        /* TODO: Implement. */
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheEast() {
        /* TODO: Implement. */
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheSouth() {
        /* TODO: Implement. */
    }

    @Test
    public void coordinatesAreCorrectForClusterGeneratedToTheWest() {
        /* TODO: Implement. */
    }
}