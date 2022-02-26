package com.slinger.greenfieldworld.model.world;

public enum RegionName {

    PLAINS("Plains"),
    FOREST("Forest"),
    WATER("Water"),
    MOUNTAIN("Mountain"),
    EMPTY("Empty");

    RegionName(String name) {}

    public static RegionName fromString(String regionName) {

        if (regionName.equalsIgnoreCase(PLAINS.name())) {
            return PLAINS;
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
