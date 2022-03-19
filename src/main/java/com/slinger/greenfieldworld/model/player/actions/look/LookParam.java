package com.slinger.greenfieldworld.model.player.actions.look;

public enum LookParam {

    NORTH,
    EAST,
    SOUTH,
    WEST,
    UNKNOWN;

    public static LookParam fromString(String checkParam) {

        if (checkParam.equalsIgnoreCase(NORTH.name()))
            return NORTH;
        else if (checkParam.equalsIgnoreCase(EAST.name()))
            return EAST;
        else if (checkParam.equalsIgnoreCase(SOUTH.name()))
            return SOUTH;
        else if (checkParam.equalsIgnoreCase(WEST.name()))
            return WEST;
        else
            return UNKNOWN;
    }
}