package com.slinger.greenfieldworld.model.items;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import lombok.Getter;

import java.util.Locale;

public abstract class Item {

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final int maxStackSize;

    @Getter
    private int stackSize = 1;

    public Item() {

        name = setName();
        description = setDescription();
        maxStackSize = setMaxStackSize();
    }

    protected abstract String setName();

    protected abstract String setDescription();

    protected abstract int setMaxStackSize();

    public void increaseStackSize() {
        increaseStackSizeBy(1);
    }

    public int increaseStackSizeBy(int increase) {

        int leftovers = 0;

        if (stackSize + increase > maxStackSize) {
            leftovers = (stackSize + increase) - maxStackSize;
            stackSize = maxStackSize;
        } else
            stackSize += increase;

        return leftovers;
    }

    public void decreaseStackSize() {
        decreaseStackSizeBy(1);
    }

    public void decreaseStackSizeBy(int decrease) {
        stackSize = Math.max(0, stackSize - decrease);
    }

    public String getNameWithArticle() {

        switch (name.substring(0, 1).toLowerCase(Locale.ROOT)) {

            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return MessageUtil.format("an {0}", name);
            default:
                return MessageUtil.format("a {0}", name);
        }
    }
}