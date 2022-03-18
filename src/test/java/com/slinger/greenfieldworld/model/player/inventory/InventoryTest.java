package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/* TODO: Some of these tests should be moved to equipment slot tests. */
class InventoryTest {

    @Test
    public void equippedItemOccupiesCorrectSlot() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack leatherBackpack = new LeatherBackpack();

        /* When */
        Item returnedItem = sut.equip(leatherBackpack);

        /* Then */
        assertNull(returnedItem);
        assertEquals(leatherBackpack, sut.getBackpackSlot().getItem());
    }

    @Test
    public void equippingAnItemOverAnotherReturnsOldItem() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack oldLeatherBackpack = new LeatherBackpack();
        LeatherBackpack newLeatherBackpack = new LeatherBackpack();

        /* When */
        sut.equip(oldLeatherBackpack);
        Item returnedItem = sut.equip(newLeatherBackpack);

        /* Then */
        assertEquals(oldLeatherBackpack, returnedItem);
        assertEquals(newLeatherBackpack, sut.getBackpackSlot().getItem());
    }
}