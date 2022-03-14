package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.headgear.Headgear;

public class HeadSlot extends EquipmentSlot<Headgear> {

    private static final String SUCCESS_OUTPUT = "You put {0} on your head.";

    @Override
    String setSuccessfulEquipOutput() {
        return SUCCESS_OUTPUT;
    }
}