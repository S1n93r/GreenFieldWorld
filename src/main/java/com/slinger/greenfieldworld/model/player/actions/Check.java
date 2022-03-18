package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;

public class Check extends InventoryInteraction {

    private static final String TRIGGER_WORD = "check";

    public Check(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        switch (parameter) {

            case "inventory":
                return inventory.check();

            case "loot":

            case "status:":
                break;

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {}"));
        }

        return MessageUtil.format("");
    }
}