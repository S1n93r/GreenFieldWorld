package com.slinger.greenfieldworld.model.world.regions;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionTypeName;
import com.slinger.greenfieldworld.model.world.events.Event;
import com.slinger.greenfieldworld.model.world.events.EventChest;
import lombok.Getter;

import java.util.Optional;

public abstract class Region {

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final RegionTypeName regionTypeName;

    @Getter
    private final String regionName;

    private final EventChest eventChest;

    protected Region(Coordinate coordinate, RegionTypeName regionTypeName, String regionName,
                     EventChest eventChest) {
        this.coordinate = coordinate;
        this.regionTypeName = regionTypeName;
        this.regionName = regionName;
        this.eventChest = eventChest;
    }

    public Optional<Event> getRandomEvent() {
        return eventChest.getRandomEvent();
    }

    protected void addEvent(Event event) {
        eventChest.addEvent(event);
    }
}