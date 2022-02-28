package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    public void directionFromStringHasCorrectValues() {

        /* When */
        Direction direction = Direction.fromString("north");

        /* Then */
        assertEquals(Direction.NORTH, direction);
    }
}