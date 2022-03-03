package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegionNameTest {

    @Test
    public void directionFromStringHasCorrectValues() {

        /* When, Then */
        assertEquals(RegionName.PLAIN, RegionName.fromString("plain"));
        assertEquals(RegionName.FOREST, RegionName.fromString("forest"));
        assertEquals(RegionName.WATER, RegionName.fromString("water"));
        assertEquals(RegionName.MOUNTAIN, RegionName.fromString("mountain"));
        assertEquals(RegionName.EMPTY, RegionName.fromString("unknown"));
    }
}