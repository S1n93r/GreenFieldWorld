package com.slinger.greenfieldworld.model.items.equipment.legarmor;

public class LinenHose extends LegArmor {

    private static final String NAME = "linen hose";

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "A hose made from courser linen, to cover the lower body and provide" +
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