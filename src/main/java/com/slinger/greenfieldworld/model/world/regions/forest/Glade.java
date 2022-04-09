package com.slinger.greenfieldworld.model.world.regions.forest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.common.gathering.GatheringChance;
import com.slinger.greenfieldworld.model.common.gathering.GatheringType;
import com.slinger.greenfieldworld.model.items.Kindling;
import com.slinger.greenfieldworld.model.items.Log;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionTypeName;
import com.slinger.greenfieldworld.model.world.events.BeggarEvent;
import com.slinger.greenfieldworld.model.world.events.EventChest;
import com.slinger.greenfieldworld.model.world.events.GoblinEvent;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.resources.Resource;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Glade extends Region {

    public Glade(Coordinate coordinate) {

        super(coordinate, RegionTypeName.FOREST, ForestRegionName.GLADE.name(), new EventChest());

        addEvent(new GoblinEvent(25));
        addEvent(new BeggarEvent(5));
    }

    @Override
    protected List<Resource> getResourcesAdded() {

        List<Resource> resourcesToAdd = new ArrayList<>();

        Collections.addAll(resourcesToAdd,
                Resource.of(GatheringType.LUMBERJACKING, GatheringChance.of(15), 3, param -> new Kindling()),
                Resource.of(GatheringType.LUMBERJACKING, GatheringChance.of(0), 3, param -> new Log())
        );

        return resourcesToAdd;
    }
}