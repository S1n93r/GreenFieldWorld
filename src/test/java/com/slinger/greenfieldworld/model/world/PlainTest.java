package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.world.regions.Plain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainTest {

    @Test
    public void triggerWordIsCorrect() {

        /* When */
        Plain sut = new Plain(Coordinate.of(0, 0));

        /* Then */
        assertEquals("PLAIN", sut.getRegionName().name());
    }
}