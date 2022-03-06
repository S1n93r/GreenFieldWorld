package com.slinger.greenfieldworld.model.world;

public enum RegionTypeName {

    PLAIN(),
    FOREST(),
    WATER(),
    MOUNTAIN(),
    EMPTY();

    public static RegionTypeName fromString(String regionName) {

        if (regionName.equalsIgnoreCase(PLAIN.name())) {
            return PLAIN;
        } else if (regionName.equalsIgnoreCase(FOREST.name())) {
            return FOREST;
        } else if (regionName.equalsIgnoreCase(WATER.name())) {
            return WATER;
        } else if (regionName.equalsIgnoreCase(MOUNTAIN.name())) {
            return MOUNTAIN;
        } else {
            return EMPTY;
        }
    }
}
