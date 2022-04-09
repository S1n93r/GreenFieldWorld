package com.slinger.greenfieldworld.model.items;

public class Kindling extends Item {

    private static final String NAME = "kindling";

    private static final int MAX_STACK_SIZE = 25;

    /* TODO: Add proper description and find name for the world. */
    private static final String DESCRIPTION = "Small branches and twigs gathered from the forest ground or chopped " +
            "from trees.";

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