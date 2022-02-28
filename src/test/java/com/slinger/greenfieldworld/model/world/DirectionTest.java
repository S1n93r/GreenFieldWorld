package com.slinger.greenfieldworld.model.world;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    public void directionFromStringHasCorrectValues() {

        /* When, Then */
        assertEquals(Direction.NORTH, Direction.fromString("north"));
        assertEquals(Direction.EAST, Direction.fromString("east"));
        assertEquals(Direction.SOUTH, Direction.fromString("south"));
        assertEquals(Direction.WEST, Direction.fromString("west"));
        assertEquals(Direction.NONE, Direction.fromString("unknown"));
    }
}