package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.items.MinyaraFLower;
import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import com.slinger.greenfieldworld.model.items.storage.LeatherPouch;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryTest {

    @Test
    public void equippingBagOnEmptySlotShowsSuccessMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LootBag lootBag = new LootBag();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LeatherPouch leatherPouch = new LeatherPouch();

        /* When */
        String outputBackpack = sut.equip(leatherBackpack, lootBag);
        String outputBeltBag = sut.equip(leatherPouch, lootBag);

        /* Then */
        assertEquals("You put a leather backpack on your back.", outputBackpack);
        assertEquals("You strap a leather pouch to your belt.", outputBeltBag);
    }

    @Test
    public void equippingBackpackOnOccupiedSlotShowsSpecificMessage() {

        /* Given */
        Inventory sut = new Inventory();

        LootBag lootBag = new LootBag();

        LeatherBackpack leatherBackpackOne = new LeatherBackpack();
        LeatherPouch leatherPouchOne = new LeatherPouch();

        sut.equip(leatherBackpackOne, lootBag);
        sut.equip(leatherPouchOne, lootBag);

        LeatherBackpack leatherBackpackTwo = new LeatherBackpack();
        LeatherPouch leatherPouchTwo = new LeatherPouch();

        /* When */
        String outputBackpack = sut.equip(leatherBackpackTwo, lootBag);
        String outputBeltBag = sut.equip(leatherPouchTwo, lootBag);

        /* Then */
        assertEquals("You swap your old leather backpack for a new leather backpack.", outputBackpack);
        assertEquals(leatherBackpackTwo, lootBag.getUnmodifiableItemList().get(0));

        assertEquals("You swap your old leather pouch for a new leather pouch.", outputBeltBag);
        assertEquals(leatherPouchTwo, lootBag.getUnmodifiableItemList().get(1));
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

        LootBag lootBag = new LootBag();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LeatherPouch leatherPouch = new LeatherPouch();

        sut.equip(leatherBackpack, lootBag);
        sut.equip(leatherPouch, lootBag);

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

        LootBag lootBag = new LootBag();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LeatherPouch leatherPouch = new LeatherPouch();

        sut.equip(leatherBackpack, lootBag);
        sut.equip(leatherPouch, lootBag);

        /* When */
        String outputBackpack = sut.storeInBackpack(new MinyaraFLower());
        String outputBeltBag = sut.storeInBeltBag(new MinyaraFLower());

        /* Then */
        assertEquals("You put a minyara flower into your leather backpack.", outputBackpack);
        assertEquals("You put a minyara flower into your leather pouch.", outputBeltBag);
    }
}