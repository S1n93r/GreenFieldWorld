package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.accessory.Accessory;

public class AccessorySlot extends EquipmentSlot<Accessory> {

    private static final String SUCCESS_OUTPUT = "You put on {0}.";

    @Override
    String setSuccessfulEquipOutput() {
        return SUCCESS_OUTPUT;
    }
}