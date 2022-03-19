package com.slinger.greenfieldworld.model.player.actions.unequip;

public enum RemoveParam {

    ACCESSORY_ONE,
    ACCESSORY_TWO,
    BODY_ARMOR,
    HEADGEAR,
    LEG_ARMOR,
    UNKNOWN;

    public static RemoveParam

    fromString(String checkParam) {

        /* TODO: This feels like to much work. Maybe I should just pass params to action and let action handle it. */
        if (checkParam.equalsIgnoreCase(ACCESSORY_ONE.name()))
            return ACCESSORY_ONE;
        else if (checkParam.equalsIgnoreCase(ACCESSORY_TWO.name()))
            return ACCESSORY_TWO;
        else if (checkParam.equalsIgnoreCase(BODY_ARMOR.name()))
            return BODY_ARMOR;
        else if (checkParam.equalsIgnoreCase(HEADGEAR.name()))
            return HEADGEAR;
        else if (checkParam.equalsIgnoreCase(LEG_ARMOR.name()))
            return LEG_ARMOR;
        else
            return UNKNOWN;
    }
}