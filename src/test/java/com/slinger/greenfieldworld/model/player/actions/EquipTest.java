package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.items.equipment.accessory.RustyIronRing;
import com.slinger.greenfieldworld.model.items.equipment.headgear.LinenHood;
import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import com.slinger.greenfieldworld.model.items.storage.LeatherPouch;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipTest {

    @Test
    public void equippingFromLootBagViaItemNameEquipsItem() {

        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LootBag lootBag = new LootBag();
        lootBag.store(new LeatherBackpack());

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");

        /* When */
        String output = sut.use("leather backpack");

        /* Then */
        assertEquals("You equip a leather backpack.", output);
    }

    @Test
    public void equippingFromLootBagViaItemIndexEquipsItem() {

        /* Given */
        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LootBag lootBag = new LootBag();
        lootBag.store(new LeatherBackpack());

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");

        /* When */
        String output = sut.use("0");

        /* Then */
        assertEquals("You equip a leather backpack.", output);
    }

    @Test
    public void equippingWithUnknownNamePromptsSpecificMessage() {

        /* Given */
        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LootBag lootBag = new LootBag();
        lootBag.store(new LeatherBackpack());

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");

        /* When */
        String output = sut.use("unknown");

        /* Then */
        assertEquals("Item 'unknown' not found.", output);
    }

    @Test
    public void equippingWithUnknownIndexPromptsSpecificMessage() {

        /* Given */
        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LootBag lootBag = new LootBag();
        lootBag.store(new LeatherBackpack());

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");

        /* When */
        String output = sut.use("12");

        /* Then */
        assertEquals("Item at index '12' not found.", output);
    }

    @Test
    public void equippingFromLootOnOccupiedSlotWithoutInventorySpace() {

        /* Given */
        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LinenHood oldLinenHood = new LinenHood();
        LinenHood newLinenHood = new LinenHood();

        LootBag lootBag = new LootBag();
        lootBag.store(oldLinenHood);
        lootBag.store(newLinenHood);

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");

        sut.use("linen hood");

        /* When */
        String output = sut.use("linen hood");

        /* Then */
        assertEquals("You put your old linen hood into the loot bag and equip your new linen hood.", output);
    }

    @Test
    public void equipItemFromInventory() {

        /* Given */
        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        leatherBackpack.store(new LinenHood());

        LootBag lootBag = new LootBag();
        lootBag.store(leatherBackpack);
        lootBag.store(new LinenHood());

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");

        sut.use("linen hood");
        sut.use("leather backpack");

        /* When */
        String output = sut.use("linen hood");

        /* Then */
        assertEquals("You put your old linen hood into your leather backpack and equip your new linen hood.", output);
    }

    @Test
    public void equipItemFromBeltBag() {

        /* Given */
        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LeatherPouch leatherPouch = new LeatherPouch();

        LootBag lootBag = new LootBag();
        lootBag.store(leatherPouch);
        lootBag.store(new RustyIronRing());

        player.setAvailableLootBag(lootBag);

        Equip sut = (Equip) player.getAction("equip");
        sut.use("leather pouch");

        leatherPouch.store(new RustyIronRing());
        sut.use("rusty iron ring");

        leatherPouch.store(new RustyIronRing());
        sut.use("rusty iron ring");

        leatherPouch.store(new RustyIronRing());
        sut.use("rusty iron ring");

        /* When */
        String output = sut.use("rusty iron ring");

        /* Then */
        assertEquals("You put your old rusty iron ring into your leather pouch and equip your new rusty iron ring.",
                output);
    }

    @Test
    public void equippingOnOccupiedSlotWhileBackpackAndBeltBagAreFullThrowsException() {

    }
}