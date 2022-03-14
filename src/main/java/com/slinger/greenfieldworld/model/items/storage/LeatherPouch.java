package com.slinger.greenfieldworld.model.items.storage;

public class LeatherPouch extends BeltBag {

    private static final String NAME = "leather pouch";

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "An ordinary leather pouch.";

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
        return 1;
    }
}
