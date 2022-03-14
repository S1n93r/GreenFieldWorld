package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.items.MinyaraFLower;
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

        /* Given */
        Inventory sut = new Inventory();

        MinyaraFLower minyaraFLower = new MinyaraFLower();

        /* When */
        String output = sut.storeInBackpack(minyaraFLower);

        /* Then */
        assertEquals("You don't have a backpack to store items in.", output);
    }

    @Test
    public void storingItemInBackpackWhileBackpackIsFullShowsSpecificMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack leatherBackpack = new LeatherBackpack();

        sut.equip(leatherBackpack);

        for (int i = 0; i < leatherBackpack.getStorageSize(); i++) {
            sut.storeInBackpack(new MinyaraFLower());
        }

        /* When */
        String output = sut.storeInBackpack(new MinyaraFLower());

        /* Then */
        assertEquals("You can't put a minyara flower into your leather backpack." +
                " Your leather backpack is full.", output);
    }

    @Test
    public void storingItemInBackpackWithEnoughRoomShowsSuccessMessage() {

    }
}