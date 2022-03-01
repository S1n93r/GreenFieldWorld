package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.world.regions.Plains;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainsTest {

    @Test
    public void triggerWordIsCorrect() {

        /* When */
        Plains sut = new Plains(Coordinate.of(0, 0));

        /* Then */
        assertEquals("PLAINS", sut.getRegionName().name());
    }
}