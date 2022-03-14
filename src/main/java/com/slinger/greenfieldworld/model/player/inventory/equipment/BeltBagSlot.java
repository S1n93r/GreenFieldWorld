package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;

public class BeltBagSlot extends EquipmentSlot<BeltBag> {

    private static final String SUCCESS_OUTPUT = "You strap {0} to your belt.";

    private static final String OUTPUT_NO_BELT_BAG = "You don't have a belt bag to store items in.";

    public String store(Item item) {

        if (!isOccupied())
            return MessageUtil.format(OUTPUT_NO_BELT_BAG);

        return this.item.store(item);
    }
}