package com.slinger.greenfieldworld.model.items.equipment.bodyarmor;

public class LinenSurcoat extends BodyArmor {

    private static final String NAME = "linen surcoat";

    private static final int MAX_STACK_SIZE = 1;

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "A surcoat made from courser linen, to cover the upper body and provide" +
            " some protection from hot or cold weather.";

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