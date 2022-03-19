package com.slinger.greenfieldworld.model.player.actions.move;

public enum MoveParam {

    NORTH,
    EAST,
    SOUTH,
    WEST,
    UNKNOWN;

    public static MoveParam fromString(String checkParam) {

        /* TODO: This feels like to much work. Maybe I should just pass params to action and let action handle it. */
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