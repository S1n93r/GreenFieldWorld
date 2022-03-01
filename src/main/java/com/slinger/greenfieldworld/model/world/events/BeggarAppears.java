package com.slinger.greenfieldworld.model.world.events;

public class BeggarAppears extends Event {

    protected static final String BEGGAR_APPEARS_PROMPT = "You see a beggar.";

    public BeggarAppears(double chance) {
        super(chance);
    }

    @Override
    public String begin() {
        return BEGGAR_APPEARS_PROMPT;
    }
}