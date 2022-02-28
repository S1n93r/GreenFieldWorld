package com.slinger.greenfieldworld.model.world;

public enum Direction {

    NORTH(),
    EAST(),
    SOUTH(),
    WEST(),
    NONE();

    public static Direction fromString(String direction) {

        if (direction.equalsIgnoreCase(NORTH.name())) {
            return NORTH;
        } else if (direction.equalsIgnoreCase(EAST.name())) {
            return EAST;
        } else if (direction.equalsIgnoreCase(SOUTH.name())) {
            return SOUTH;
        } else if (direction.equalsIgnoreCase(WEST.name())) {
            return WEST;
        } else {
            return NONE;
        }
    }
}