package com.slinger.greenfieldworld.model.items.equipment.headgear;

public class LinenHood extends Headgear {

    private static final String NAME = "linen hood";

    private static final int MAX_STACK_SIZE = 1;

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "A hood made from courser linen, to cover the head and provide some " +
            "protection from hot or cold weather.";

    @Override
    protected String setName() {
        return NAME;
    }

    @Override
    protected String setDescription() {
        return DESCRIPTION;
    }

    @Override
    protected int setMaxStackSize() {
        return MAX_STACK_SIZE;
    }
}