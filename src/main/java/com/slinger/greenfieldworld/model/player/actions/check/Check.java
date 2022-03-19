package com.slinger.greenfieldworld.model.player.actions.check;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.InventoryInteraction;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;

public class Check extends InventoryInteraction {

    private static final String TRIGGER_WORD = "check";

    public Check(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        CheckParam checkParam = CheckParam.fromString(parameter);

        switch (checkParam) {

            case INVENTORY:
                return inventory.check();

            case LOOT:
                break;

            case STATUS:
                break;

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {}"));
        }

        return MessageUtil.format("");
    }
}