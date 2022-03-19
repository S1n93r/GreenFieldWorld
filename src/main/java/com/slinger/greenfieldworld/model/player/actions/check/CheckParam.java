package com.slinger.greenfieldworld.model.player.actions.check;

public enum CheckParam {

    INVENTORY,
    LOOT,
    STATUS,
    UNKNOWN;

    public static CheckParam fromString(String checkParam) {

        /* TODO: This feels like to much work. Maybe I should just pass params to action and let action handle it. */
        if (checkParam.equalsIgnoreCase(INVENTORY.name()))
            return INVENTORY;
        else if (checkParam.equalsIgnoreCase(LOOT.name()))
            return LOOT;
        else if (checkParam.equalsIgnoreCase(STATUS.name()))
            return STATUS;
        else
            return UNKNOWN;
    }
}