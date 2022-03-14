package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Bag extends Item {

    private static final String OUTPUT_BAG_FULL = "You can't put {0} into your {1}. Your {1} is full.";
    private static final String OUTPUT_STORING_SUCCESSFUL = "You put {0} into your {1}.";

    private final int storageSize;

    private final List<Item> itemList = new ArrayList<>();

    protected Bag() {
        this.storageSize = setStorageSize();
    }

    public String store(Item item) {

        if (itemList.size() == storageSize)
            return MessageUtil.format(OUTPUT_BAG_FULL, item.getName(), getName());

        itemList.add(item);

        return MessageUtil.format(OUTPUT_STORING_SUCCESSFUL, item.getName(), getName());
    }

    abstract int setStorageSize();
}