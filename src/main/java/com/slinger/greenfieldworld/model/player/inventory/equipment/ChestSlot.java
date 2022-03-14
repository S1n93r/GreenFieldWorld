package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.bodyarmor.BodyArmor;

public class ChestSlot extends EquipmentSlot<BodyArmor> {

    private static final String SUCCESS_OUTPUT = "You put {0} on your chest.";

    @Override
    String setSuccessfulEquipOutput() {
        return SUCCESS_OUTPUT;
    }
}