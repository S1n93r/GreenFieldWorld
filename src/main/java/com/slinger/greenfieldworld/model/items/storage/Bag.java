package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Bag extends Item {

    private final int storageSize;

    private final List<Item> itemList = new ArrayList<>();

    protected Bag() {
        this.storageSize = setStorageSize();
    }

    public boolean store(Item item) {

        if (itemList.size() == storageSize)
            return false;

        return itemList.add(item);
    }

    public List<Item> getUnmodifiableItemList() {
        return Collections.unmodifiableList(itemList);
    }

    abstract int setStorageSize();


}