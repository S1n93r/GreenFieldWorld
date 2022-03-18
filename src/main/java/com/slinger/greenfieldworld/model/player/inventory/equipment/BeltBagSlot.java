package com.slinger.greenfieldworld.model.player.inventory.equipment;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;

import java.util.List;

public class BeltBagSlot extends EquipmentSlot<BeltBag> {

    private static final String SUCCESS_OUTPUT = "You strap {0} to your belt.";

    private static final String OUTPUT_NO_BELT_BAG = "You don't have a belt bag to store items in.";

    public String store(Item item) {

        if (!isOccupied())
            return MessageUtil.format(OUTPUT_NO_BELT_BAG);

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

    public boolean hasSpace() {

        if (item == null)
            return false;

        return item.hasSpace();
    }

    public String getBagName() {
        return item.getName();
    }

    public String getBagNameWithArticle() {
        return item.getNameWithArticle();
    }

    public List<Item> getUnmodifiableItemList() {
        return this.item.getUnmodifiableItemList();
    }
}