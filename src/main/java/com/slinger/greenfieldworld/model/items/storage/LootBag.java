package com.slinger.greenfieldworld.model.items.storage;

public class LootBag extends Bag {

    private static final String NAME = "loot bag";
    private static final String DESCRIPTION = "A loot bag containing the equipment of a slain foe.";

    @Override
    protected String setName() {
        return NAME;
    }

    @Override
    protected String setDescription() {
        return DESCRIPTION;
    }

    @Override
    int setStorageSize() {
        return 5;
    }
}