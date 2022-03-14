package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Bag extends Item {

    private static final String OUTPUT_BAG_FULL = "You can't put {0} into your {1}. Your {2} is full.";
    private static final String OUTPUT_STORING_SUCCESSFUL = "You put {0} into your {1}.";

    @Getter
    private final int storageSize;

    private final List<Item> itemList = new ArrayList<>();

    protected Bag() {
        this.storageSize = setStorageSize();
    }

    public String store(Item item) {

        /* TODO: remove second use of getName() as soon as MessageUtil can handle multiple {0}s. */
        if (itemList.size() == storageSize)
            return MessageUtil.format(OUTPUT_BAG_FULL, item.getNameWithArticle(), getName(), getName());

        itemList.add(item);

        return MessageUtil.format(OUTPUT_STORING_SUCCESSFUL, item.getNameWithArticle(), getName());
    }

    public List<Item> getUnmodifiableItemList() {
        return Collections.unmodifiableList(itemList);
    }

    abstract int setStorageSize();
}