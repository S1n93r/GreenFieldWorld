package com.slinger.greenfieldworld.model.items.tools;

import com.slinger.greenfieldworld.model.common.gathering.GatheringChance;

public class BareHanded extends Tool {

    @Override
    protected String setName() {
        return null;
    }

    @Override
    protected String setDescription() {
        return null;
    }

    @Override
    protected int setMaxStackSize() {
        return 0;
    }

    @Override
    GatheringChance setHavestChance() {
        return GatheringChance.of(0);
    }

    @Override
    GatheringChance setChopChance() {
        return GatheringChance.of(0);
    }

    @Override
    GatheringChance setMineChance() {
        return GatheringChance.of(0);
    }
}