package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.player.inventory.equipment.*;

public class Inventory {

    private final HeadSlot headSlot = new HeadSlot();
    private final ChestSlot chestSlot = new ChestSlot();
    private final LegsSlot legsSlot = new LegsSlot();

    private final AccessorySlot accessorySlotA = new AccessorySlot();
    private final AccessorySlot accessorySlotB = new AccessorySlot();

    private final BackpackSlot backpackSlot = new BackpackSlot();
    private final BeltBagSlot beltBagSlot = new BeltBagSlot();

    public String storeInBackpack(Item item) {

        if (!backpackSlot.isOccupied())
            return MessageUtil.format("You don't have a backpack to store items.");

        boolean storingSuccessful = backpackSlot.getItem().store(item);

        if (storingSuccessful)
            return MessageUtil.format("You put {0} into your backpack.", item.getName());

        return MessageUtil.format("You can't put {0} into your backpack. Your backpack is full.",
                item.getName());
    }

    public String storeInBeltBag(Item item) {

        if (!beltBagSlot.isOccupied())
            return "You don't have a bag on your belt to store items.";

        boolean storingSuccessful = beltBagSlot.getItem().store(item);

        if (storingSuccessful)
            return MessageUtil.format("You put {0} into your belt bag.", item.getName());

        return MessageUtil.format("You can't put {0} into your belt bag. Your belt bag is full.",
                item.getName());
    }

    public void equip(Item item) {

    }
}