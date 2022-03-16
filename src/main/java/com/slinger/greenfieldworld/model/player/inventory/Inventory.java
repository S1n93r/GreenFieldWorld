package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.common.MessageUtil;
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

    private static final String ITEM_LIST_SEPARATOR = "----------";

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

    public String check() {
        return checkBackpack() + System.lineSeparator() + checkBeltBag();
    }

    private String checkBackpack() {

        StringBuilder output = new StringBuilder("Backpack:" + System.lineSeparator());
        output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

        if (!backpackSlot.isOccupied()) {

            output.append(MessageUtil.format("You don't have a backpack.")).append(System.lineSeparator());
            output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

            return output.toString();
        }

        int itemIndex = 1;

        for (Item item : backpackSlot.getUnmodifiableItemList()) {

            output.append(MessageUtil.format("[{0}] - {1}", itemIndex, item.getName()))
                    .append(System.lineSeparator());

            itemIndex++;
        }

        output.append(ITEM_LIST_SEPARATOR);

        return output.toString();
    }

    private String checkBeltBag() {

        StringBuilder output = new StringBuilder("Belt bag:" + System.lineSeparator());
        output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

        if (!beltBagSlot.isOccupied()) {

            output.append(MessageUtil.format("You don't have a belt bag.")).append(System.lineSeparator());
            output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

            return output.toString();
        }

        int itemIndex = 1 + backpackSlot.getUnmodifiableItemList().size();

        for (Item item : beltBagSlot.getUnmodifiableItemList()) {

            output.append(MessageUtil.format("[{0}] - {1}", itemIndex, item.getName()))
                    .append(System.lineSeparator());

            itemIndex++;
        }

        output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

        return output.toString();
    }
}
