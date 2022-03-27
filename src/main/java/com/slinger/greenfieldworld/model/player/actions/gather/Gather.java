package com.slinger.greenfieldworld.model.player.actions.gather;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.InventoryInteraction;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;

public class Gather extends InventoryInteraction {

    private static final String TRIGGER_WORD = "gather";

    public Gather(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        GatherParam gatherParam = GatherParam.fromString(parameter);

        switch (gatherParam) {

            case PLANTS:
                break;

            case WOOD:
                break;

            case ORE:
                break;

            case UNKNOWN:
                break;

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {}"));
        }

        return MessageUtil.format("");
    }
}