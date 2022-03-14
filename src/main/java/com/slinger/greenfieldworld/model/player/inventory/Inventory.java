package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.equipment.accessory.Accessory;
import com.slinger.greenfieldworld.model.items.equipment.bodyarmor.BodyArmor;
import com.slinger.greenfieldworld.model.items.equipment.headgear.Headgear;
import com.slinger.greenfieldworld.model.items.equipment.legarmor.LegArmor;
import com.slinger.greenfieldworld.model.items.storage.Backpack;
import com.slinger.greenfieldworld.model.items.storage.Bag;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;
import com.slinger.greenfieldworld.model.player.inventory.equipment.*;

public class Inventory {

    private final HeadSlot headSlot = new HeadSlot();

    private final ChestSlot chestSlot = new ChestSlot();

    private final LegsSlot legsSlot = new LegsSlot();

    private final AccessorySlots accessorySlots = new AccessorySlots();

    private final BackpackSlot backpackSlot = new BackpackSlot();

    private final BeltBagSlot beltBagSlot = new BeltBagSlot();

    public String storeInBackpack(Item item) {
        return backpackSlot.store(item);
    }

    public String storeInBeltBag(Item item) {
        return beltBagSlot.store(item);
    }

    public String equip(Item item, Bag bagEquippedFrom) {

        if (item instanceof Headgear) {
            return headSlot.equip((Headgear) item, bagEquippedFrom);
        } else if (item instanceof BodyArmor) {
            return chestSlot.equip((BodyArmor) item, bagEquippedFrom);
        } else if (item instanceof LegArmor) {
            return legsSlot.equip((LegArmor) item, bagEquippedFrom);
        } else if (item instanceof Accessory) {
            return accessorySlots.equip((Accessory) item, bagEquippedFrom);
        } else if (item instanceof Backpack) {
            return backpackSlot.equip((Backpack) item, bagEquippedFrom);
        } else if (item instanceof BeltBag) {
            return beltBagSlot.equip((BeltBag) item, bagEquippedFrom);
        }

        throw new SwitchCaseNotDefinedException("The item you try to equip is of a type not known to the equip " +
                "function.");
    }
}