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

        return getItem().store(item);
    }

    public Item fetchItemFromBag(String itemName) {

        if (getItem() == null)
            return null;

        return getItem().fetchItem(itemName);
    }

    public Item fetchItemFromBag(int itemIndex) {

        if (getItem() == null)
            return null;

        return getItem().fetchItem(itemIndex);
    }

    public boolean hasBagSpace() {

        if (getItem() == null)
            return false;

        return getItem().hasSpace();
    }

    public String getBagName() {

        if (getItem() == null)
            return MessageUtil.emptyString();

        return getItem().getName();
    }

    public String getBagNameWithArticle() {

        if (getItem() == null)
            return MessageUtil.emptyString();

        return getItem().getNameWithArticle();
    }

    public List<Item> getUnmodifiableItemList() {

        if (getItem() == null)
            return Collections.emptyList();

        return getItem().getUnmodifiableItemList();
    }

    @Override
    EquipmentSlotType setEquipmentSlotType() {
        return EquipmentSlotType.BACKPACK;
    }
}