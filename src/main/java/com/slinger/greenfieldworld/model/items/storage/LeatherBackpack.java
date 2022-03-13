package com.slinger.greenfieldworld.model.items.storage;

public class LeatherBackpack extends Backpack {

    private static final String NAME = "Leather Backpack";

    @Override
    public String setName() {
        return NAME;
    }

    @Override
    int setStorageSize() {
        return 10;
    }
}
