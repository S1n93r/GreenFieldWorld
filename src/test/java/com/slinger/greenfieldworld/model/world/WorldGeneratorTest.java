package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WorldGeneratorTest {

    private final WorldGenerator sut = new WorldGenerator();

    @Test
    public void afterGeneratingRegionMapIsNotEmpty() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        /* When */
        sut.generateRegions(world);

        /* Then */
        assertFalse(world.getUnmodifiableRegionMap().isEmpty());
    }

    @Test
    public void afterGeneratingRegionMapFitsGridSize() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        /* When */
        sut.generateRegions(world);

        /* Then */
        assertEquals(9, world.getUnmodifiableRegionMap().size());
    }

    @Test
    public void afterGeneratingRegionMapHasCorrectRegionTypes() {

        /* Given */
        World world = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        /* When */
        sut.generateRegions(world);

        /* Then */
        assertEquals(RegionName.PLAINS, world.getUnmodifiableRegionMap().get(new Coordinate(0, 0)).getRegionName());
        assertEquals(RegionName.PLAINS, world.getUnmodifiableRegionMap().get(new Coordinate(1, 1)).getRegionName());
        assertEquals(RegionName.PLAINS, world.getUnmodifiableRegionMap().get(new Coordinate(2, 2)).getRegionName());
    }
}