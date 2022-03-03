package com.slinger.greenfieldworld.model.world.events;

public class BeggarEvent extends Event {

    protected static final String BEGGAR_PROMPT = "You see a beggar.";

    public BeggarEvent(double chance) {
        super(chance);
    }

    @Override
    public String begin() {
        return BEGGAR_PROMPT;
    }
}