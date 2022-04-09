package com.slinger.greenfieldworld.model.items.equipment;

import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.player.inventory.equipment.EquipmentSlotType;
import lombok.Getter;

public abstract class Equipment extends Item {

    @Getter
    private final EquipmentSlotType equipmentSlotType;

    protected Equipment() {
        this.equipmentSlotType = setEquipmentSlotType();
    }

    protected abstract EquipmentSlotType setEquipmentSlotType();
}