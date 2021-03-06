package com.slinger.greenfieldworld.model.world.regions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.slinger.greenfieldworld.model.items.storage.RegionInventory;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionTypeName;
import com.slinger.greenfieldworld.model.world.events.Event;
import com.slinger.greenfieldworld.model.world.events.EventChest;
import com.slinger.greenfieldworld.model.world.regions.resources.Resource;
import com.slinger.greenfieldworld.model.world.regions.resources.ResourceDeposit;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

public abstract class Region {

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final RegionTypeName regionTypeName;

    @Getter
    private final String regionName;

    @Getter
    @JsonIgnore
    private final ResourceDeposit resourceDeposit = new ResourceDeposit();

    @Getter
    @JsonIgnore
    private final RegionInventory regionInventory;

    private final EventChest eventChest;

    protected Region(Coordinate coordinate, RegionTypeName regionTypeName, String regionName,
                     EventChest eventChest) {

        this.coordinate = coordinate;
        this.regionTypeName = regionTypeName;
        this.regionName = regionName;

        this.eventChest = eventChest;

        regionInventory = new RegionInventory();

        getResourcesAdded().forEach(resourceDeposit::addResource);
    }

    protected abstract List<Resource> getResourcesAdded();

    public Optional<Event> getRandomEvent() {
        return eventChest.getRandomEvent();
    }

    protected void addEvent(Event event) {
        eventChest.addEvent(event);
    }
}