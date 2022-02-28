package com.slinger.greenfieldworld.model.world;

import lombok.Getter;

public abstract class Region {

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final RegionName regionName;

    protected Region(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.regionName = setRegionName();
    }

    abstract RegionName setRegionName();
}