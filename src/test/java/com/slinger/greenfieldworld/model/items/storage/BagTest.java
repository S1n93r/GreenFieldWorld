package com.slinger.greenfieldworld.model.items.storage;

import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.MinyaraFLower;
import com.slinger.greenfieldworld.model.items.equipment.accessory.RustyIronRing;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagTest {

    @Test
    public void storingItemsInAnyBag() {

        /* Given */
        LootBag sut = new LootBag();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        MinyaraFLower minyaraFLower = new MinyaraFLower();
        RustyIronRing rustyIronRing = new RustyIronRing();

        /* When */
        sut.store(leatherBackpack);
        sut.store(minyaraFLower);
        sut.store(rustyIronRing);

        /* Then */
        assertEquals(3, sut.getUnmodifiableItemList().size());

        assertEquals(leatherBackpack, sut.getUnmodifiableItemList().get(0));
        assertEquals(minyaraFLower, sut.getUnmodifiableItemList().get(1));
        assertEquals(rustyIronRing, sut.getUnmodifiableItemList().get(2));
    }

    @Test
    public void getItemFromAnyBagViewItemName() {

        /* Given */
        LootBag sut = new LootBag();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        MinyaraFLower minyaraFLower = new MinyaraFLower();
        RustyIronRing rustyIronRing = new RustyIronRing();

        sut.store(leatherBackpack);
        sut.store(minyaraFLower);
        sut.store(rustyIronRing);

        /* When */
        Item item = sut.fetchItem("minyara flower");

        /* Then */
        assertEquals(minyaraFLower, item);
    }

    @Test
    public void getItemFromAnyBagViewItemIndex() {

        /* Given */
        LootBag sut = new LootBag();

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        MinyaraFLower minyaraFLower = new MinyaraFLower();
        RustyIronRing rustyIronRing = new RustyIronRing();

        sut.store(leatherBackpack);
        sut.store(minyaraFLower);
        sut.store(rustyIronRing);

        /* When */
        Item item = sut.fetchItem(1);

        /* Then */
        assertEquals(minyaraFLower, item);
    }
}