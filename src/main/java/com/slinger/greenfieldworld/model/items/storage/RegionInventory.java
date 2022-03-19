package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class RegionInventory extends Backpack {

    /* TODO: Add proper description. */
    private static final String DESCRIPTION = "An ordinary leather backpack.";

    private static final String NAME_BASE = "Regional inventory ({0})";

    private final String name;

    public RegionInventory(Region region) {
        name = MessageUtil.format(NAME_BASE, region.getCoordinate());
    }

    @Override
    public String setName() {
        return name;
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
