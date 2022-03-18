package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.Item;
import lombok.Getter;

public abstract class EquipmentSlot<T extends Item> {

    private static final String SWAP_OUTPUT = "You swap your old {0} for a new {1}.";
    private static final String EQUIP_OUTPUT = "You equip {0}.";

    @Getter
    protected T item;

    public Item equip(T item) {

        if (this.item == null) {
            this.item = item;
            return null;
        }

        T previousItem = this.item;

        this.item = item;

        return previousItem;
    }

    public boolean isOccupied() {
        return item != null;
    }
}