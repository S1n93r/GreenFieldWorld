package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.Bag;

public abstract class EquipmentSlot<T extends Item> {

    private static final String SWAP_OUTPUT = "You swap your old {0} for a new {1}.";

    protected T item;

    public String equip(T item, Bag bagEquippedFrom) {

        String output = MessageUtil.format("");

        T previousItem = this.item;

        this.item = item;

        if (previousItem != null)
            bagEquippedFrom.store(previousItem);

        return output;
    }

    public boolean isOccupied() {
        return item != null;
    }

    abstract String setSuccessfulEquipOutput();
}