package com.slinger.greenfieldworld.model.world.regions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionName;
import com.slinger.greenfieldworld.model.world.events.BeggarEvent;
import com.slinger.greenfieldworld.model.world.events.GoblinEvent;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Forest extends Region {

    public Forest(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    RegionName setRegionName() {
        return RegionName.FOREST;
    }

    @Override
    void addEvents() {
        addEvent(new GoblinEvent(25));
        addEvent(new BeggarEvent(5));
    }
}