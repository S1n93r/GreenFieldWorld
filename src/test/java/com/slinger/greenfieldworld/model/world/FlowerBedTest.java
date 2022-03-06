package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.world.regions.plain.FlowerBed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowerBedTest {

    @Test
    public void triggerWordIsCorrect() {

        /* When */
        FlowerBed sut = new FlowerBed(Coordinate.of(0, 0));

        /* Then */
        assertEquals("PLAIN", sut.getRegionTypeName().name());
    }
}