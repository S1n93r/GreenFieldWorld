package com.slinger.greenfieldworld.model.player.actions.gather;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.InventoryInteraction;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class Harvest extends InventoryInteraction {

    private static final String TRIGGER_WORD = "gather";

    public Harvest(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        Region region = player.getRegion();

        /* TODO: User tool from player as soon as Player class has 'tool' slot.*/
        region.getResourceDeposit().gather();

        return MessageUtil.format("");
    }
}