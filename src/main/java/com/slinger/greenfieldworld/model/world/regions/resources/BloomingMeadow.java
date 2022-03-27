package com.slinger.greenfieldworld.model.world.regions.resources;

import com.slinger.greenfieldworld.model.common.DiceUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.MinyaraFLower;

import java.util.ArrayList;
import java.util.List;

public class BloomingMeadow extends Resource {

    private static final String NAME = "blooming meadow";

    private static final int CHANCE_MINYARA_FLOWER = 25;
    private static final int MAX_QUANTITY_MINYARA_FLOWERS = 3;

    @Override
    List<Item> gather() {

        List<Item> resourcesGathered = new ArrayList<>();

        int chanceDice = DiceUtil.rollDice(100);

        if (chanceDice <= CHANCE_MINYARA_FLOWER) {

            int quantityDice = DiceUtil.rollDice(MAX_QUANTITY_MINYARA_FLOWERS);

            /* TODO: Replace with setting a stack size, when implemented in item. */
            for (int i = 0; i < quantityDice; i++)
                resourcesGathered.add(new MinyaraFLower());
        }

        return resourcesGathered;
    }

    @Override
    String setName() {
        return NAME;
    }
}