package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.Backpack;

import java.util.List;

public class BackpackSlot extends EquipmentSlot<Backpack> {

    private static final String SUCCESS_OUTPUT = "You put {0} on your back.";

    private static final String OUTPUT_NO_BACKPACK = "You don't have a backpack to store items in.";

    public String store(Item item) {

        if (!isOccupied())
            return MessageUtil.format(OUTPUT_NO_BACKPACK);

        return this.item.store(item);
    }

    public List<Item> getUnmodifiableItemList() {
        return this.item.getUnmodifiableItemList();
    }
}