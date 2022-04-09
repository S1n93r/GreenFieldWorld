package com.slinger.greenfieldworld.model.world.regions.resources;

import com.slinger.greenfieldworld.model.common.gathering.GatheringChance;
import com.slinger.greenfieldworld.model.common.gathering.GatheringType;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.Kindling;
import com.slinger.greenfieldworld.model.items.Log;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceDepositTest {

    @Test
    public void gatheringYieldsOnlyItemsWithChanceToGet() {

        /* Given */
        Resource twigResource = Resource.of(
                GatheringType.LUMBERJACKING,
                GatheringChance.of(100),
                3,
                param -> new Kindling());

        Resource logResource = Resource.of(
                GatheringType.LUMBERJACKING,
                GatheringChance.of(0),
                1,
                param -> new Log());

        /* When */
        ResourceDeposit sut = new ResourceDeposit();

        sut.addResource(twigResource);
        sut.addResource(logResource);

        List<Item> gatheredItems = sut.gather();

        /* Then */
        assertEquals(1, gatheredItems.size());
        assertTrue(gatheredItems.get(0) instanceof Kindling);
    }

    @Test
    public void gatheringYieldsCorrectMaxStackSize() {

        Resource twigResource = Resource.of(
                GatheringType.LUMBERJACKING,
                GatheringChance.of(100),
                3,
                param -> new Kindling());

        ResourceDeposit sut = new ResourceDeposit();

        sut.addResource(twigResource);

        List<Item> gatheredItems = sut.gather();

        assertTrue(gatheredItems.get(0).getStackSize() <= 3);
    }
}