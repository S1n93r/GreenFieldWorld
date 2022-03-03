package com.slinger.greenfieldworld.model.world.regions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionName;
import com.slinger.greenfieldworld.model.world.events.BeggarEvent;
import com.slinger.greenfieldworld.model.world.events.GoblinEvent;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plain extends Region {

    public Plain(Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    RegionName setRegionName() {
        return RegionName.PLAIN;
    }

    @Override
    void addEvents() {
        addEvent(new GoblinEvent(10));
        addEvent(new BeggarEvent(5));
    }
}