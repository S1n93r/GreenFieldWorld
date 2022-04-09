package com.slinger.greenfieldworld.model.items;

public class Log extends Item {

    private static final String NAME = "log";

    private static final int MAX_STACK_SIZE = 1;

    /* TODO: Add proper description and find name for the world. */
    private static final String DESCRIPTION = "The vivid material irradiates a strong scent of tree resin.";

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