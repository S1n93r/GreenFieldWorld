package com.slinger.greenfieldworld.model.player.actions.unequip;

public enum RemoveParam {

    ACCESSORY_ONE,
    ACCESSORY_TWO,
    BODY_ARMOR,
    HEADGEAR,
    LEG_ARMOR,
    UNKNOWN;

    private static final String COMMAND_ACCESSORY_ONE = "accessory one";
    private static final String COMMAND_ACCESSORY_TWO = "accessory two";
    private static final String COMMAND_BODY_ARMOR = "body armor";
    private static final String COMMAND_HEADGEAR = "headgear";
    private static final String COMMAND_LEG_ARMOR = "leg armor";

    public static RemoveParam fromString(String checkParam) {

        /* TODO: This feels like to much work. Maybe I should just pass params to action and let action handle it. */
        if (checkParam.equalsIgnoreCase(COMMAND_ACCESSORY_ONE))
            return ACCESSORY_ONE;
        else if (checkParam.equalsIgnoreCase(COMMAND_ACCESSORY_TWO))
            return ACCESSORY_TWO;
        else if (checkParam.equalsIgnoreCase(COMMAND_BODY_ARMOR))
            return BODY_ARMOR;
        else if (checkParam.equalsIgnoreCase(COMMAND_HEADGEAR))
            return HEADGEAR;
        else if (checkParam.equalsIgnoreCase(COMMAND_LEG_ARMOR))
            return LEG_ARMOR;
        else
            return UNKNOWN;
    }
}