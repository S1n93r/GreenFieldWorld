package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WorldGeneratorTest {

    private final WorldGenerator sut = new WorldGenerator();

    @Test
    public void afterGeneratingClusterMapIsNotEmpty() {

        /* Given */
        World world = World.builder().id(1).name("Test").gridSize(3).build();

        /* When */
        sut.generateInitialCluster(world);

        /* Then */
        assertFalse(world.getUnmodifiableClusterMap().isEmpty());
    }

    @Test
    public void generatedInitialClusterFitsGridSize() {

        /* Given */
        World world = World.builder().id(1).name("Test").gridSize(3).build();

        /* When */
        sut.generateInitialCluster(world);

        /* Then */
        Cluster actualCluster = world.getUnmodifiableClusterMap().get(new Coordinate(0, 0));

        assertEquals(9, actualCluster.getUnmodifiableRegionsMap().size());
    }

    @Test
    public void generatedRegionsHaveCorrectContent() {

        /* Given */
        World world = World.builder().id(1).name("Test").gridSize(3).build();

        /* When */
        sut.generateInitialCluster(world);

        /* Then */
        Cluster actualCluster = world.getUnmodifiableClusterMap().get(new Coordinate(0, 0));

        assertEquals(RegionName.PLAINS,
                actualCluster.getUnmodifiableRegionsMap().get(new Coordinate(0, 0)).getRegionName());
        assertEquals(RegionName.PLAINS,
                actualCluster.getUnmodifiableRegionsMap().get(new Coordinate(1, 1)).getRegionName());
        assertEquals(RegionName.PLAINS,
                actualCluster.getUnmodifiableRegionsMap().get(new Coordinate(2, 2)).getRegionName());
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