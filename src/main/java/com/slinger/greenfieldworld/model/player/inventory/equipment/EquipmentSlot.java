package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.Item;
import lombok.Getter;

public abstract class EquipmentSlot<T extends Item> {

    @Getter
    private final EquipmentSlotType type;

    protected T item;

    protected EquipmentSlot() {
        type = setEquipmentSlotType();
    }

    public Item equip(T item) {

        if (this.item == null) {
            this.item = item;
            return null;
        }

        T previousItem = this.item;

        this.item = item;

        return previousItem;
    }

    public Item remove() {

        Item removedItem = this.item;

        this.item = null;

        return removedItem;
    }

    public boolean isOccupied() {
        return item != null;
    }

    abstract EquipmentSlotType setEquipmentSlotType();
}