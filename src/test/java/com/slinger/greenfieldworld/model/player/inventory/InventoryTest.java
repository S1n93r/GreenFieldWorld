package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {

    @Test
    public void equippingBackpackOnEmptySlotShowsSuccessMessage() {

        /* Given */
        Inventory sut = new Inventory();
        LeatherBackpack leatherBackpack = new LeatherBackpack();

        /* When */
        String output = sut.equip(leatherBackpack);

        /* Then */
        assertEquals("You put a leather backpack on your back.", output);
    }

    @Test
    public void equippingBackpackOnOccupiedSlotShowsSpecificMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack leatherBackpackOne = new LeatherBackpack();

        sut.equip(leatherBackpackOne);

        LeatherBackpack leatherBackpackTwo = new LeatherBackpack();

        /* When */
        String output = sut.equip(leatherBackpackTwo);

        /* Then */
        assertEquals("You swap your old leather backpack for a new leather backpack.", output);
    }

    @Test
    public void storingItemInBackpackWhileNoBackpackIsEquippedShowsSpecificMessage() {

    }

    @Test
    public void storingItemInBackpackWhileBackpackIsFullShowsSpecificMessage() {

    }

    @Test
    public void storingItemInBackpackWithEnoughRoomShowsSuccessMessage() {

    }
}