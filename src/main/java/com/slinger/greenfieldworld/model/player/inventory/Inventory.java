package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.equipment.Equipment;
import com.slinger.greenfieldworld.model.items.equipment.accessory.Accessory;
import com.slinger.greenfieldworld.model.items.equipment.bodyarmor.BodyArmor;
import com.slinger.greenfieldworld.model.items.equipment.hand.Hand;
import com.slinger.greenfieldworld.model.items.equipment.headgear.Headgear;
import com.slinger.greenfieldworld.model.items.equipment.legarmor.LegArmor;
import com.slinger.greenfieldworld.model.items.storage.Backpack;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;
import com.slinger.greenfieldworld.model.player.inventory.equipment.*;
import lombok.Getter;

public class Inventory {

    private static final String ITEM_LIST_SEPARATOR = "----------";

    @Getter
    private final HandsSlot handsSlot = new HandsSlot();

    @Getter
    private final HeadgearSlot headgearSlot = new HeadgearSlot();

    @Getter
    private final BodyArmorSlot bodyArmorSlot = new BodyArmorSlot();

    @Getter
    private final LegArmorSlot legArmorSlot = new LegArmorSlot();

    @Getter
    private final AccessoriesSlot accessoriesSlot = new AccessoriesSlot();

    @Getter
    private final BackpackSlot backpackSlot = new BackpackSlot();

    @Getter
    private final BeltBagSlot beltBagSlot = new BeltBagSlot();

    public String storeInBackpack(Item item) {
        return backpackSlot.store(item);
    }

    public String storeInBeltBag(Item item) {
        return beltBagSlot.store(item);
    }

    public Item equip(Equipment equipment) {

        switch (equipment.getEquipmentSlotType()) {

            case ACCESSORY:
                return accessoriesSlot.equip((Accessory) equipment);

            case HAND:
                return handsSlot.equip((Hand) equipment);
            case HEADGEAR:
                return headgearSlot.equip((Headgear) equipment);
            case BODY_ARMOR:
                return bodyArmorSlot.equip((BodyArmor) equipment);
            case LEG_ARMOR:
                return legArmorSlot.equip((LegArmor) equipment);
            case BACKPACK:
                return backpackSlot.equip((Backpack) equipment);
            case BELT_BAG:
                return beltBagSlot.equip((BeltBag) equipment);
            default:
                throw new SwitchCaseNotDefinedException();
        }
    }

    public String check() {
        return checkBackpack() + System.lineSeparator() + checkBeltBag();
    }

    public Item fetchItem(String itemName) {

        Item item = backpackSlot.fetchItemFromBag(itemName);

        if (item == null)
            item = beltBagSlot.fetchItemFromBag(itemName);

        return item;
    }

    public Item fetchItem(int itemIndex) {

        Item item = backpackSlot.fetchItemFromBag(itemIndex);

        if (item == null)
            item = beltBagSlot.fetchItemFromBag(itemIndex - backpackSlot.getUnmodifiableItemList().size());

        return item;
    }

    private String checkBackpack() {

        StringBuilder output = new StringBuilder("Backpack:" + System.lineSeparator());
        output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

        if (!backpackSlot.isOccupied()) {

            output.append(MessageUtil.format("You don't have a backpack.")).append(System.lineSeparator());
            output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

            return output.toString();
        }

        int itemIndex = 0;

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

        int itemIndex = backpackSlot.getUnmodifiableItemList().size();

        for (Item item : beltBagSlot.getUnmodifiableItemList()) {

            output.append(MessageUtil.format("[{0}] - {1}", itemIndex, item.getName()))
                    .append(System.lineSeparator());

            itemIndex++;
        }

        output.append(ITEM_LIST_SEPARATOR).append(System.lineSeparator());

        return output.toString();
    }
}
