package com.slinger.greenfieldworld.model.items.storage;

public class RegionInventory extends Backpack {

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "An ordinary leather backpack.";

    private static final String NAME = "regional inventory";

    private static final int MAX_STACK_SIZE = 1;
    private static final int STORAGE_SIZE = 100;

    @Override
    public String setName() {
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

    @Override
    int setStorageSize() {
        return STORAGE_SIZE;
    }
}
