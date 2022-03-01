package com.slinger.greenfieldworld.model.world.events;

import lombok.Getter;

public abstract class Event {

    @Getter
    private final double chance;

    protected Event(double chance) {
        this.chance = chance;
    }

    public abstract String begin();
}