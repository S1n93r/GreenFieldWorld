package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegionTypeNameTest {

    @Test
    public void directionFromStringHasCorrectValues() {

        /* When, Then */
        assertEquals(RegionTypeName.PLAIN, RegionTypeName.fromString("plain"));
        assertEquals(RegionTypeName.FOREST, RegionTypeName.fromString("forest"));
        assertEquals(RegionTypeName.WATER, RegionTypeName.fromString("water"));
        assertEquals(RegionTypeName.MOUNTAIN, RegionTypeName.fromString("mountain"));
        assertEquals(RegionTypeName.EMPTY, RegionTypeName.fromString("unknown"));
    }
}