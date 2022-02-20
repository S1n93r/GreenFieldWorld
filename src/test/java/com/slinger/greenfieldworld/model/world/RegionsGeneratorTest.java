package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class RegionsGeneratorTest {

    private final RegionsGenerator sut = new RegionsGenerator();

    @Test
    public void afterGeneratingRegionsMapIsNotEmpty() {

        /* Given */
        World world = World.builder().id(1).name("Test").build();

        /* When */
        sut.generateInitialRegions(world);

        /* Then */
        assertFalse(world.getUnmodifiableRegionsMap().isEmpty());
    }

    @Test
    public void generatedRegionsFitGridSize() {

        /* Given */
        World world = World.builder().id(1).name("Test").build();

        /* When */
        sut.generateInitialRegions(world, 3);

        /* Then */
        assertEquals(9, world.getUnmodifiableRegionsMap().size());
    }

    @Test
    public void generatedRegionsHaveCorrectContent() {

        /* Given */
        World world = World.builder().id(1).name("Test").build();

        /* When */
        sut.generateInitialRegions(world, 3);

        /* Then */
        assertEquals(RegionName.PLAINS, world.getRegion(new Coordinate(0, 0)).getRegionName());
        assertEquals(RegionName.PLAINS, world.getRegion(new Coordinate(1, 1)).getRegionName());
        assertEquals(RegionName.PLAINS, world.getRegion(new Coordinate(2, 2)).getRegionName());
    }
}