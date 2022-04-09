package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.player.inventory.equipment.EquipmentSlotType;

public abstract class BeltBag extends Bag {

    @Override
    protected EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.BELT_BAG;
    }
}