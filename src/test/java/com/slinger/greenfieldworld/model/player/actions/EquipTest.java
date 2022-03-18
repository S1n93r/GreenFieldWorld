package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import org.junit.jupiter.api.Test;

class EquipTest {

    @Test
    public void equippingFromLootBagViaItemNameEquipsItem() {

        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        LootBag lootBag = new LootBag();
        lootBag.store(new LeatherBackpack());

        player.setAvailableLootBag(lootBag);

        String output = player.getAction("equip").use("leather backpack");
    }

    @Test
    public void equippingFromLootBagViaItemIndexEquipsItem() {

        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        String output = player.getAction("equip").use("1");
    }
}