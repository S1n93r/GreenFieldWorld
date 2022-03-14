package com.slinger.greenfieldworld.model.items.equipment.bodyarmor;

public class LinenSurcoat extends BodyArmor {

    private static final String NAME = "linen surcoat";

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
}