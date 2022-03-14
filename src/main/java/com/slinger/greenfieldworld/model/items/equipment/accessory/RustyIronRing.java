package com.slinger.greenfieldworld.model.items.equipment.accessory;

public class RustyIronRing extends Accessory {

    private static final String NAME = "rusty iron ring";

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "An iron ring covered with the ravages of time. But even in the older " +
            "days, this was not more then an ordinary ring.";

    @Override
    protected String setName() {
        return NAME;
    }

    @Override
    protected String setDescription() {
        return DESCRIPTION;
    }
}