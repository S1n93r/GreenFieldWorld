package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegionNameTest {

    @Test
    public void directionFromStringHasCorrectValues() {

        /* When */
        RegionName regionName = RegionName.fromString("plains");

        /* Then */
        assertEquals(RegionName.PLAINS, regionName);
    }
}