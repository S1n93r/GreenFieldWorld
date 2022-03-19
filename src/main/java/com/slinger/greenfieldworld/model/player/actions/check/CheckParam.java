package com.slinger.greenfieldworld.model.player.actions.check;

public enum CheckParam {

    INVENTORY,
    LOOT,
    STATUS,
    UNKNOWN;

    public static CheckParam fromString(String checkParam) {

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