package com.slinger.greenfieldworld.model.items.tools;

import com.slinger.greenfieldworld.model.common.gathering.GatheringChance;
import com.slinger.greenfieldworld.model.common.gathering.GatheringType;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;

public abstract class Tool extends Item {

    private final GatheringChance harvestingChance;
    private final GatheringChance lumberjackingChance;
    private final GatheringChance miningChance;

    public Tool() {

        this.harvestingChance = setHavestChance();
        this.lumberjackingChance = setChopChance();
        this.miningChance = setMineChance();
    }

    public GatheringChance getGatheringChanceBonus(GatheringType gatheringType) {

        switch (gatheringType) {

            case HARVESTING:
                return harvestingChance;

            case LUMBERJACKING:
                return lumberjackingChance;

            case MINING:
                return miningChance;

            default:
                throw new SwitchCaseNotDefinedException();
        }
    }

    abstract GatheringChance setHavestChance();

    abstract GatheringChance setChopChance();

    abstract GatheringChance setMineChance();
}