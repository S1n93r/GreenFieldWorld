package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.bodyarmor.BodyArmor;

public class BodyArmorSlot extends EquipmentSlot<BodyArmor> {

    @Override
    EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.BODY_ARMOR;
    }
}