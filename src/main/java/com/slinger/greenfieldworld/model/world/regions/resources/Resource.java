package com.slinger.greenfieldworld.model.world.regions.resources;

import com.slinger.greenfieldworld.model.common.DiceUtil;
import com.slinger.greenfieldworld.model.common.gathering.GatheringChance;
import com.slinger.greenfieldworld.model.common.gathering.GatheringType;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.tools.Tool;
import javafx.util.Callback;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
public class Resource<T extends Item> {

    GatheringType gatheringType;

    GatheringChance gatheringChance;

    int maxYield;

    Callback<Integer, T> itemGenerator;

    public T gather(Tool tool) {

        if (!gatheringSuccessful(tool))
            return null;

        return itemGenerator.call(DiceUtil.rollDice(maxYield));
    }

    private boolean gatheringSuccessful(Tool tool) {

        int gatheringChanceResource = gatheringChance.getChance();
        int gatheringBonusTool = tool.getGatheringChanceBonus(gatheringType).getChance();

        int totalGatheringChance = gatheringChanceResource + gatheringBonusTool;

        return DiceUtil.rollDiceForPercent() <= totalGatheringChance;
    }
}