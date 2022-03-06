package com.slinger.greenfieldworld.model.world.regions.forest;

public enum ForestRegionName {

    BEAR_CAVE,
    BRIER_WOOD,
    GLADE,

    EMPTY;

    public static ForestRegionName fromString(String regionName) {

        if (regionName.equalsIgnoreCase(GLADE.name())) {
            return GLADE;
        } else if (regionName.equalsIgnoreCase(BRIER_WOOD.name())) {
            return BRIER_WOOD;
        } else if (regionName.equalsIgnoreCase(BEAR_CAVE.name())) {
            return BEAR_CAVE;
        } else {
            return EMPTY;
        }
    }
}