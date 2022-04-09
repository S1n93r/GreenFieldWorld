package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.equipment.Equipment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Bag extends Equipment {

    private static final String OUTPUT_BAG_FULL = "You can't put {0} into your {1}. Your {2} is full.";
    private static final String OUTPUT_STORING_SUCCESSFUL = "You put {0} into your {1}.";

    @Getter
    private final int storageSize;

    private final List<Item> itemList = new ArrayList<>();

    protected Bag() {
        this.storageSize = setStorageSize();
    }

    public String store(Item item) {

        if (hasSpace()) {

            itemList.add(item);

            return MessageUtil.format(OUTPUT_STORING_SUCCESSFUL, item.getNameWithArticle(), getName());
        }

        /* TODO: remove second use of getName() as soon as MessageUtil can handle multiple {0}s. */
        return MessageUtil.format(OUTPUT_BAG_FULL, item.getNameWithArticle(), getName(), getName());
    }

    public List<Item> getUnmodifiableItemList() {
        return Collections.unmodifiableList(itemList);
    }

    public Item getItem(String itemName) {

        for (Item item : itemList)
            if (item.getName().equalsIgnoreCase(itemName))
                return item;

        return null;
    }

    /* TODO: Try to cover via unit test. */
    public Item fetchItem(String itemName) {

        Item item = getItem(itemName);

        if (item != null)
            itemList.remove(item);

        return item;
    }

    public Item getItem(int itemIndex) {

        try {
            return itemList.get(itemIndex);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /* TODO: Try to cover via unit test. */
    public Item fetchItem(int itemIndex) {

        Item item = getItem(itemIndex);

        if (item != null)
            itemList.remove(item);

        return item;
    }

    public boolean hasSpace() {
        return itemList.size() < storageSize;
    }

    abstract int setStorageSize();
}