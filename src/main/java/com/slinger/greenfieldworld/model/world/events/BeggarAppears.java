package com.slinger.greenfieldworld.model.world.events;

public class BeggarAppears extends Event {

    protected BeggarAppears(double chance) {
        super(chance);
    }

    @Override
    public String begin() {
        return "You see a beggar";
    }
}