package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.Bag;

public abstract class EquipmentSlot<T extends Item> {

    private static final String SWAP_OUTPUT = "You swap your old {0} for a new {1}.";
    private static final String EQUIP_OUTPUT = "You equip {0}.";

    protected T item;

    public String equip(T item, Bag bagEquippedFrom) {

        if (this.item == null) {
            this.item = item;
            return MessageUtil.format(EQUIP_OUTPUT, item.getNameWithArticle());
        }

        T previousItem = this.item;

        bagEquippedFrom.store(previousItem);

        this.item = item;

        return MessageUtil.format(SWAP_OUTPUT, previousItem.getName(), item.getName());
    }

    public boolean isOccupied() {
        return item != null;
    }
}