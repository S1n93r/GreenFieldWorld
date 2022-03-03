package com.slinger.greenfieldworld.model.world.events;

public class GoblinEvent extends Event {

    protected static final String GOBLIN_PROMPT = "You see a Goblin.";

    public GoblinEvent(double chance) {
        super(chance);
    }

    @Override
    public String begin() {
        return GOBLIN_PROMPT;
    }
}