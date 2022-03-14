package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.legarmor.LegArmor;

public class LegsSlot extends EquipmentSlot<LegArmor> {

    private static final String SUCCESS_OUTPUT = "You put {0} on your legs.";

    @Override
    String setSuccessfulEquipOutput() {
        return SUCCESS_OUTPUT;
    }
}