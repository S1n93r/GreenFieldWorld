package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LookTest {

    @Test
    public void triggerWordIsCorrect() {

        /* Given */
        Player player = mock(Player.class);

        /* When */
        Look sut = new Look(player);

        /* Then */
        assertEquals("look", sut.getTriggerWord());
    }

    @Test
    public void usingMoveToChangePlayerPosition() {

        /* Given */
        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Testopia", 5);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(player);

        Look sut = new Look(player);

        /* When */
        String lookNorth = sut.use("north");
        String lookEast = sut.use("east");
        String lookSouth = sut.use("south");
        String lookWest = sut.use("west");
        String lookNowhere = sut.use("unknown");

        /* Then */
        assertEquals("You look NORTH and see a PLAINS.", lookNorth);
        assertEquals("You look EAST and see a PLAINS.", lookEast);
        assertEquals("You look SOUTH and see a PLAINS.", lookSouth);
        assertEquals("You look WEST and see a PLAINS.", lookWest);
        assertEquals("You did not look in any direction.", lookNowhere);
    }
}