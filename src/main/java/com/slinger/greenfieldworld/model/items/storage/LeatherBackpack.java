package com.slinger.greenfieldworld.model.items.storage;

public class LeatherBackpack extends Backpack {

    private static final String NAME = "leather backpack";

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "An ordinary leather backpack.";

    @Override
    public String setName() {
        return NAME;
    }

    @Override
    protected String setDescription() {
        return DESCRIPTION;
    }

    @Override
    int setStorageSize() {
        return 10;
    }
}
