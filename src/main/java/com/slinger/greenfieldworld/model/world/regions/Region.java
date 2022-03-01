package com.slinger.greenfieldworld.model.world.regions;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionName;
import com.slinger.greenfieldworld.model.world.events.Event;
import com.slinger.greenfieldworld.model.world.events.EventChest;
import lombok.Getter;

import java.util.Optional;

public abstract class Region {

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final RegionName regionName;

    private final EventChest eventChest = new EventChest();

    protected Region(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.regionName = setRegionName();
    }

    public Optional<Event> getRandomEvent() {
        return eventChest.getRandomEvent();
    }

    public void addEvent(Event event) {
        eventChest.addEvent(event);
    }

    abstract RegionName setRegionName();
}