package com.slinger.greenfieldworld.model.player.actions.equip;

public enum EquipParam {

    BY_NAME,
    BY_INDEX;

    public static EquipParam fromString(String checkParam) {

        /* TODO: This feels like to much work. Maybe I should just pass params to action and let action handle it. */
        if (checkParam.replaceAll("[0-9]", "").length() == 0)
            return BY_INDEX;
        else
            return BY_NAME;
    }
}