package com.slinger.greenfieldworld.model.items.storage;

public class RegionInventory extends Backpack {

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "An ordinary leather backpack.";

    private static final String NAME = "regional inventory";

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
        return 100;
    }
}
