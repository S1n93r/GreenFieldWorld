package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.Item;

public abstract class EquipmentSlot<T extends Item> {

    protected T item;

    public T equip(T item) {

        T previousItem = this.item;

        this.item = item;

        return previousItem;
    }

    public boolean isOccupied() {
        return item != null;
    }
}