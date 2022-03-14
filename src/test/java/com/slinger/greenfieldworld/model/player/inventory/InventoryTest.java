package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.items.MinyaraFLower;
import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import com.slinger.greenfieldworld.model.items.storage.LeatherPouch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {

    @Test
    public void equippingBagOnEmptySlotShowsSuccessMessage() {

        /* Given */
        Inventory sut = new Inventory();
        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LeatherPouch leatherPouch = new LeatherPouch();

        /* When */
        String outputBackpack = sut.equip(leatherBackpack);
        String outputBeltBag = sut.equip(leatherPouch);

        /* Then */
        assertEquals("You put a leather backpack on your back.", outputBackpack);
        assertEquals("You strap a leather pouch to your belt.", outputBeltBag);
    }

    @Test
    public void equippingBackpackOnOccupiedSlotShowsSpecificMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack leatherBackpackOne = new LeatherBackpack();
        LeatherPouch leatherPouchOne = new LeatherPouch();

        sut.equip(leatherBackpackOne);
        sut.equip(leatherPouchOne);

        LeatherBackpack leatherBackpackTwo = new LeatherBackpack();
        LeatherPouch leatherPouchTwo = new LeatherPouch();

        /* When */
        String outputBackpack = sut.equip(leatherBackpackTwo);
        String outputBeltBag = sut.equip(leatherPouchTwo);

        /* Then */
        assertEquals("You swap your old leather backpack for a new leather backpack.", outputBackpack);
        assertEquals("You swap your old leather pouch for a new leather pouch.", outputBeltBag);
    }

    @Test
    public void storingItemInBackpackWhileNoBackpackIsEquippedShowsSpecificMessage() {

        /* Given */
        Inventory sut = new Inventory();

        MinyaraFLower minyaraFLower = new MinyaraFLower();

        /* When */
        String outputBackpack = sut.storeInBackpack(minyaraFLower);
        String outputBeltBag = sut.storeInBeltBag(minyaraFLower);

        /* Then */
        assertEquals("You don't have a backpack to store items in.", outputBackpack);
        assertEquals("You don't have a belt bag to store items in.", outputBeltBag);
    }

    @Test
    public void storingItemInBackpackWhileBackpackIsFullShowsSpecificMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LeatherPouch leatherPouch = new LeatherPouch();

        sut.equip(leatherBackpack);
        sut.equip(leatherPouch);

        for (int i = 0; i < leatherBackpack.getStorageSize(); i++) {
            sut.storeInBackpack(new MinyaraFLower());
        }

        for (int i = 0; i < leatherPouch.getStorageSize(); i++) {
            sut.storeInBeltBag(new MinyaraFLower());
        }

        /* When */
        String outputBackpack = sut.storeInBackpack(new MinyaraFLower());
        String outputBeltBag = sut.storeInBeltBag(new MinyaraFLower());

        /* Then */
        assertEquals("You can't put a minyara flower into your leather backpack." +
                " Your leather backpack is full.", outputBackpack);
        assertEquals("You can't put a minyara flower into your leather pouch." +
                " Your leather pouch is full.", outputBeltBag);
    }

    @Test
    public void storingItemInBackpackWithEnoughRoomShowsSuccessMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LeatherPouch leatherPouch = new LeatherPouch();

        sut.equip(leatherBackpack);
        sut.equip(leatherPouch);

        /* When */
        String outputBackpack = sut.storeInBackpack(new MinyaraFLower());
        String outputBeltBag = sut.storeInBeltBag(new MinyaraFLower());

        /* Then */
        assertEquals("You put a minyara flower into your leather backpack.", outputBackpack);
        assertEquals("You put a minyara flower into your leather pouch.", outputBeltBag);
    }
}