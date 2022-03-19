package com.slinger.greenfieldworld.model.player.actions.unequip;

import com.slinger.greenfieldworld.model.items.equipment.headgear.LinenHood;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveTest {

    @Test
    public void removingViaItemNameDropsItemToRegionInventory() {

        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Test World", 3);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(player);

        LootBag lootBag = new LootBag();
        lootBag.store(new LinenHood());

        player.setAvailableLootBag(lootBag);

        player.getAction("equip").use("linen hood");

        Remove sut = (Remove) player.getAction("remove");

        /* When */
        String output = sut.use("headgear");

        /* Then */
        assertEquals("You remove your linen hood (HEADGEAR) and put it to the regional inventory.", output);
    }
}