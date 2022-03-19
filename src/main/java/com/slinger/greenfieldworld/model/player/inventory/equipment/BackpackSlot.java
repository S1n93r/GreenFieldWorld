package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.Backpack;

import java.util.Collections;
import java.util.List;

public class BackpackSlot extends EquipmentSlot<Backpack> {

    private static final String SUCCESS_OUTPUT = "You put {0} on your back.";

    private static final String OUTPUT_NO_BACKPACK = "You don't have a backpack to store items in.";

    public String store(Item item) {

        if (!isOccupied())
            return MessageUtil.format(OUTPUT_NO_BACKPACK);

        return this.item.store(item);
    }

    public Item fetchItemFromBag(String itemName) {

        if (item == null)
            return null;

        return item.fetchItem(itemName);
    }

    public Item fetchItemFromBag(int itemIndex) {

        if (item == null)
            return null;

        return item.fetchItem(itemIndex);
    }

    public boolean hasBagSpace() {

        if (item == null)
            return false;

        return item.hasSpace();
    }

    public String getBagName() {

        if (item == null)
            return MessageUtil.emptyString();

        return item.getName();
    }

    public String getBagNameWithArticle() {

        if (item == null)
            return MessageUtil.emptyString();

        return item.getNameWithArticle();
    }

    public List<Item> getUnmodifiableItemList() {

        if (item == null)
            return Collections.emptyList();

        return this.item.getUnmodifiableItemList();
    }

    @Override
    EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.BACKPACK;
    }
}