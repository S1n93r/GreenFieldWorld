package com.slinger.greenfieldworld.model.world.regions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionName;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plains extends Region {

    public Plains(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    RegionName setRegionName() {
        return RegionName.PLAINS;
    }
}