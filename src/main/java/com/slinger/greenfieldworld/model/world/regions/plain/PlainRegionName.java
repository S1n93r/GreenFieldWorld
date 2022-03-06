package com.slinger.greenfieldworld.model.world.regions.plain;

public enum PlainRegionName {

    FLOWER_BED,
    HILL,
    TALL_GRASS,

    EMPTY;

    public static PlainRegionName fromString(String regionName) {

        if (regionName.equalsIgnoreCase(FLOWER_BED.name())) {
            return FLOWER_BED;
        } else if (regionName.equalsIgnoreCase(HILL.name())) {
            return HILL;
        } else if (regionName.equalsIgnoreCase(TALL_GRASS.name())) {
            return TALL_GRASS;
        } else {
            return EMPTY;
        }
    }
}