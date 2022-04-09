package com.slinger.greenfieldworld.model.world.regions.water;

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
public class HotSprings extends Region {

    public HotSprings(Coordinate coordinate) {

        super(coordinate, RegionTypeName.WATER, WaterRegionName.HOT_SPRINGS.name(), new EventChest());

        addEvent(new GoblinEvent(10));
        addEvent(new BeggarEvent(5));
    }

    @Override
    protected ResourceDeposit setUpResourceDeposit() {
        return new ResourceDeposit();
    }
}