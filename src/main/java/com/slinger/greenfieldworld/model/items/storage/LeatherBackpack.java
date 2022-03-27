package com.slinger.greenfieldworld.model.items.storage;

public class LeatherBackpack extends Backpack {

    private static final String NAME = "leather backpack";

    private static final int MAX_STACK_SIZE = 1;
    private static final int STORAGE_SIZE = 10;

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
    protected int setMaxStackSize() {
        return MAX_STACK_SIZE;
    }

    @Override
    int setStorageSize() {
        return STORAGE_SIZE;
    }
}
