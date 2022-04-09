package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.hand.Hand;

public class HandSlot extends EquipmentSlot<Hand> {

    @Override
    EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.HAND;
    }
}