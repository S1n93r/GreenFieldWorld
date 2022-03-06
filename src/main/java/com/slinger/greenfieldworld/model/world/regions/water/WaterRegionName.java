package com.slinger.greenfieldworld.model.world.regions.water;

public enum WaterRegionName {

    HOT_SPRINGS,
    LAKE,
    RIVER,

    EMPTY;

    public static WaterRegionName fromString(String regionName) {

        if (regionName.equalsIgnoreCase(HOT_SPRINGS.name())) {
            return HOT_SPRINGS;
        } else if (regionName.equalsIgnoreCase(LAKE.name())) {
            return LAKE;
        } else if (regionName.equalsIgnoreCase(RIVER.name())) {
            return RIVER;
        } else {
            return EMPTY;
        }
    }
}