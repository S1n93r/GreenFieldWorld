package com.slinger.greenfieldworld.model.player.actions.unequip;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.equipment.bodyarmor.LinenSurcoat;
import com.slinger.greenfieldworld.model.items.equipment.headgear.LinenHood;
import com.slinger.greenfieldworld.model.items.equipment.legarmor.LinenHose;
import com.slinger.greenfieldworld.model.items.storage.LeatherBackpack;
import com.slinger.greenfieldworld.model.items.storage.LeatherPouch;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import org.junit.jupiter.api.Test;

import static com.slinger.greenfieldworld.model.player.actions.unequip.Remove.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveTest {

    @Test
    public void removingViaItemNameDropsItemToRegionInventory() {

        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Test World", 3);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(player);

        LinenHood linenHood = new LinenHood();

        LootBag lootBag = new LootBag();
        lootBag.store(linenHood);

        player.setAvailableLootBag(lootBag);

        player.getAction("equip").use("linen hood");

        Remove sut = (Remove) player.getAction("remove");

        /* When */
        String output = sut.use("headgear");

        /* Then */
        String expectedOutput = MessageUtil.format(OUTPUT_REMOVE_SUCCESS_THE, linenHood.getName(),
                player.getRegion().getRegionInventory().getName());

        assertEquals(expectedOutput, output);
    }

    @Test
    public void removingViaItemNamePutsItemToBackpack() {

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        LeatherBackpack leatherBackpack = new LeatherBackpack();
        LinenSurcoat linenSurcoat = new LinenSurcoat();

        LootBag lootBag = new LootBag();
        lootBag.store(leatherBackpack);
        lootBag.store(linenSurcoat);

        player.setAvailableLootBag(lootBag);

        player.getAction("equip").use("leather backpack");
        player.getAction("equip").use("linen surcoat");

        Remove sut = (Remove) player.getAction("remove");

        /* When */
        String output = sut.use("body armor");

        /* Then */
        String expectedOutput = MessageUtil.format(OUTPUT_REMOVE_SUCCESS_YOUR, linenSurcoat.getName(),
                leatherBackpack.getName());

        assertEquals(expectedOutput, output);
    }

    @Test
    public void removingViaItemNamePutsItemToBeltBag() {

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        LinenHose linenHose = new LinenHose();
        LeatherPouch leatherPouch = new LeatherPouch();

        LootBag lootBag = new LootBag();
        lootBag.store(leatherPouch);
        lootBag.store(linenHose);

        player.setAvailableLootBag(lootBag);

        player.getAction("equip").use("leather pouch");
        player.getAction("equip").use("linen hose");

        Remove sut = (Remove) player.getAction("remove");

        /* When */
        String output = sut.use("leg armor");

        /* Then */
        String expectedOutput = MessageUtil.format(OUTPUT_REMOVE_SUCCESS_YOUR, linenHose.getName(),
                leatherPouch.getName());

        assertEquals(expectedOutput, output);
    }

    @Test
    public void removingFromUnknownSlotViaItemName() {

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        LootBag lootBag = new LootBag();
        lootBag.store(new LeatherPouch());
        lootBag.store(new LinenHose());

        player.setAvailableLootBag(lootBag);

        player.getAction("equip").use("leather pouch");
        player.getAction("equip").use("linen hose");

        Remove sut = (Remove) player.getAction("remove");

        String command = "unknown slot";

        /* When */
        String output = sut.use(command);

        /* Then */
        assertEquals(MessageUtil.format(OUTPUT_ACTION_PARAM_UNKNOWN, command), output);
    }
}