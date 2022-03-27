package com.slinger.greenfieldworld.model.items.storage;

public class LootBag extends Bag {

    private static final String NAME = "loot bag";
    private static final String DESCRIPTION = "A loot bag containing the equipment of a slain foe.";

    private static final int MAX_STACK_SIZE = 1;
    private static final int STORAGE_SIZE = 10;

    @Override
    protected String setName() {
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