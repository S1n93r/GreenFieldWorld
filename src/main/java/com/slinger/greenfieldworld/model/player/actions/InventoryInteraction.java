package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;

public abstract class InventoryInteraction extends Action {

    protected final Inventory inventory;

    protected InventoryInteraction(Player player, Inventory inventory) {

        super(player);

        this.inventory = inventory;
    }
}