package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.headgear.Headgear;

public class HeadgearSlot extends EquipmentSlot<Headgear> {

    @Override
    EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.HEADGEAR;
    }
}