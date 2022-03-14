package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.Item;
import lombok.Getter;

public abstract class EquipmentSlot<T extends Item> {

    protected T item;

    @Getter
    private boolean occupied;

    public Object equip(T item) {

        T previousItem = item;

        this.item = item;

        return previousItem;
    }
}