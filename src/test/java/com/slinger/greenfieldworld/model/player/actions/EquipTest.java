package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
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

        String output = sut.use("leather backpack");

        assertEquals("", output);
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

        String output = sut.use("0");

        assertEquals("", output);
    }
}