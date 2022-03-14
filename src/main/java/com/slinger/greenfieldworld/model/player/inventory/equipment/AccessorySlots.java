package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.items.equipment.accessory.Accessory;
import com.slinger.greenfieldworld.model.items.storage.Bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessorySlots extends EquipmentSlot<Accessory> {

    private static final String SUCCESS_OUTPUT = "You put on {0}.";

    private final List<AccessorySlot> accessorySlotList = new ArrayList<>(2);

    AccessorySlot accessorySlotA = new AccessorySlot();
    AccessorySlot accessorySlotB = new AccessorySlot();

    public AccessorySlots() {
        accessorySlotList.add(accessorySlotA);
        accessorySlotList.add(accessorySlotB);
    }

    @Override
    public String equip(Accessory item, Bag bagEquippedFrom) {

        if (!accessorySlotA.isOccupied())
            return accessorySlotA.equip(item, bagEquippedFrom);

        if (!accessorySlotB.isOccupied())
            return accessorySlotB.equip(item, bagEquippedFrom);

        Collections.reverse(accessorySlotList);

        return accessorySlotList.get(0).equip(item, bagEquippedFrom);
    }
}