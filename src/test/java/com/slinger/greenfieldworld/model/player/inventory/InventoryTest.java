package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {

    @Test
    public void equippingBackpackGoesToBackpackSlot() {

        Inventory inventory = new Inventory();
        LeatherBackpack leatherBackpack = new LeatherBackpack();

        String output = inventory.equip(leatherBackpack);

        assertEquals("You put a leather backpack on your back.", output);
    }
}