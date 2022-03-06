package com.slinger.greenfieldworld.model.world.regions.mountain;

public enum MountainRegionName {

    ABANDONED_MINE,
    FOOTHILLS,
    UPLANDS,

    EMPTY;

    public static MountainRegionName fromString(String regionName) {

        if (regionName.equalsIgnoreCase(FOOTHILLS.name())) {
            return FOOTHILLS;
        } else if (regionName.equalsIgnoreCase(ABANDONED_MINE.name())) {
            return ABANDONED_MINE;
        } else if (regionName.equalsIgnoreCase(UPLANDS.name())) {
            return UPLANDS;
        } else {
            return EMPTY;
        }
    }
}