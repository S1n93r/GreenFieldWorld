package com.slinger.greenfieldworld.model.player.actions.gather;

public enum GatherParam {

    PLANTS,
    WOOD,
    ORE,
    UNKNOWN;

    public static GatherParam fromString(String checkParam) {

        if (checkParam.equalsIgnoreCase(PLANTS.name()))
            return PLANTS;
        else if (checkParam.equalsIgnoreCase(WOOD.name()))
            return WOOD;
        else if (checkParam.equalsIgnoreCase(ORE.name()))
            return ORE;
        else
            return UNKNOWN;
    }
}