package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.equipment.accessory.Accessory;
import com.slinger.greenfieldworld.model.items.equipment.bodyarmor.BodyArmor;
import com.slinger.greenfieldworld.model.items.equipment.headgear.Headgear;
import com.slinger.greenfieldworld.model.items.equipment.legarmor.LegArmor;
import com.slinger.greenfieldworld.model.items.storage.Backpack;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;
import com.slinger.greenfieldworld.model.player.inventory.equipment.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {

    private final HeadSlot headSlot = new HeadSlot();
    private final ChestSlot chestSlot = new ChestSlot();
    private final LegsSlot legsSlot = new LegsSlot();

    private final List<AccessorySlot> accessorySlotList = new ArrayList<>(2);

    private final AccessorySlot accessorySlotA = new AccessorySlot();
    private final AccessorySlot accessorySlotB = new AccessorySlot();

    private final BackpackSlot backpackSlot = new BackpackSlot();
    private final BeltBagSlot beltBagSlot = new BeltBagSlot();

    public String storeInBackpack(Item item) {
        return backpackSlot.store(item);
    }

    public String storeInBeltBag(Item item) {
        return beltBagSlot.store(item);
    }

    public String equip(Item item) {

        /* TODO: Or move all outputs and conditions to EquipmentSlot class with setters for outputs. */
        if (item instanceof Headgear) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            Headgear previousHeadgear = headSlot.equip((Headgear) item);

            if (previousHeadgear == null)
                return MessageUtil.format("You put {0} on your head.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousHeadgear.getName(), item.getName());

        } else if (item instanceof BodyArmor) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            BodyArmor previousBodyArmor = chestSlot.equip((BodyArmor) item);

            if (previousBodyArmor == null)
                return MessageUtil.format("You put {0} on your chest.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousBodyArmor.getName(), item.getName());

        } else if (item instanceof LegArmor) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            LegArmor previousLegArmor = legsSlot.equip((LegArmor) item);

            if (previousLegArmor == null)
                return MessageUtil.format("You put {0} on your legs.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousLegArmor.getName(), item.getName());

        } else if (item instanceof Accessory) {

            for (AccessorySlot slot : accessorySlotList) {
                if (!slot.isOccupied()) {
                    slot.equip((Accessory) item);
                    return MessageUtil.format("You put on {0}.", item.getNameWithArticle());
                }
            }

            Collections.reverse(accessorySlotList);

            /* TODO: Needs to go to hand slot, when stripped of. */
            Accessory previousLegAccessory = accessorySlotList.get(0).equip((Accessory) item);

            return MessageUtil.format("You swap your old {0} for a new {1}.",
                    previousLegAccessory.getName(), item.getName());

        } else if (item instanceof Backpack) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            Backpack previousBackpack = backpackSlot.equip((Backpack) item);

            if (previousBackpack == null)
                return MessageUtil.format("You put {0} on your back.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousBackpack.getName(), item.getName());

        } else if (item instanceof BeltBag) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            BeltBag previousBeltBag = beltBagSlot.equip((BeltBag) item);

            if (previousBeltBag == null)
                return MessageUtil.format("You strap {0} to your belt.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousBeltBag.getName(), item.getName());
        }

        throw new SwitchCaseNotDefinedException("The item you try to equip is of a type not known to the equip " +
                "function.");
    }
}