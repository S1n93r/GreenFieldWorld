package com.slinger.greenfieldworld.model.world.regions.forest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionTypeName;
import com.slinger.greenfieldworld.model.world.events.BeggarEvent;
import com.slinger.greenfieldworld.model.world.events.EventChest;
import com.slinger.greenfieldworld.model.world.events.GoblinEvent;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.resources.ResourceDeposit;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BearCave extends Region {

    public BearCave(Coordinate coordinate) {

        super(coordinate, RegionTypeName.FOREST, ForestRegionName.BEAR_CAVE.name(), new EventChest());

        addEvent(new GoblinEvent(25));
        addEvent(new BeggarEvent(5));
    }

    @Override
    protected ResourceDeposit setUpResourceDeposit() {
        return new ResourceDeposit();
    }
}