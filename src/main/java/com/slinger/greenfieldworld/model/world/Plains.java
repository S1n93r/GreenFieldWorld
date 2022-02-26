package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plains extends Region {

    public Plains(Coordinate coordinate) {
        super(coordinate, RegionName.PLAINS);
    }
}