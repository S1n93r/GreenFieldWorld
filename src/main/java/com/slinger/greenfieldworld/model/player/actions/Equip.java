package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;

public class Equip extends InventoryInteraction {

    private static final String TRIGGER_WORD = "equip";

    public Equip(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        LootBag lootBag = player.getAvailableLootBag();

        return MessageUtil.format("");
    }

    private String equipByItemName() {
        return MessageUtil.format("");
    }

    private String equipByItemIndex() {
        return MessageUtil.format("");
    }
}