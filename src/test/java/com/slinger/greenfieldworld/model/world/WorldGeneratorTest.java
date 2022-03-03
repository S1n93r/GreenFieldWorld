package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WorldGeneratorTest {

    private final WorldGenerator sut = new WorldGenerator();

    @Test
    public void afterGeneratingRegionMapIsNotEmpty() {

        /* Given, When */
        World world = sut.generateWorld("Test", 3);

        /* Then */
        assertFalse(world.getUnmodifiableRegionMap().isEmpty());
    }

    @Test
    public void afterGeneratingRegionMapFitsGridSize() {

        /* Given, When */
        World world = sut.generateWorld("Test", 3);

        /* Then */
        assertEquals(9, world.getUnmodifiableRegionMap().size());
    }
}