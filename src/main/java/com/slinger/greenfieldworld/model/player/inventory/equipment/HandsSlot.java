package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.equipment.hand.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandsSlot extends EquipmentSlot<Hand> {

    private static final String SUCCESS_OUTPUT = "You put on {0}.";

    private final List<HandSlot> handSlotList = new ArrayList<>(2);

    HandSlot handSlotLeft = new HandSlot();
    HandSlot handSlotRight = new HandSlot();

    public HandsSlot() {
        handSlotList.add(handSlotLeft);
        handSlotList.add(handSlotRight);
    }

    @Override
    public Item equip(Hand item) {

        if (!handSlotLeft.isOccupied())
            return handSlotLeft.equip(item);

        if (!handSlotRight.isOccupied())
            return handSlotRight.equip(item);

        Collections.reverse(handSlotList);

        return handSlotList.get(0).equip(item);
    }

    @Override
    EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.ACCESSORY;
    }
}