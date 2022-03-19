package com.slinger.greenfieldworld.model.player.actions.equip;

public enum EquipParam {

    BY_NAME,
    BY_INDEX;

    public static EquipParam fromString(String checkParam) {

        if (checkParam.replaceAll("[0-9]", "").length() == 0)
            return BY_INDEX;
        else
            return BY_NAME;
    }
}