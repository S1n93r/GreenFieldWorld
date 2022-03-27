package com.slinger.greenfieldworld.model.items;

public class MinyaraFLower extends Item {

    private static final String NAME = "minyara flower";

    private static final int MAX_STACK_SIZE = 50;

    /* TODO: Add proper description and find name for the world. */
    private static final String DESCRIPTION = "Loth ya minya yara - or the flower of the first times it often " +
            "referred to as the first and most common flower growing in the open plains of GREEN FIELD WORLD.";

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