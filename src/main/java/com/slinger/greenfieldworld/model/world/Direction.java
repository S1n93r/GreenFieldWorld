package com.slinger.greenfieldworld.model.world;

public enum Direction {

    NORTH(),
    EAST(),
    SOUTH(),
    WEST(),
    NONE();

    public static Direction fromString(String regionName) {

        if (regionName.equalsIgnoreCase(NORTH.name())) {
            return NORTH;
        } else if (regionName.equalsIgnoreCase(EAST.name())) {
            return EAST;
        } else if (regionName.equalsIgnoreCase(SOUTH.name())) {
            return SOUTH;
        } else if (regionName.equalsIgnoreCase(WEST.name())) {
            return WEST;
        } else {
            return NONE;
        }
    }
}