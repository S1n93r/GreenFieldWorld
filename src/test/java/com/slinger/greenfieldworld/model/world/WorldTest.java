package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WorldTest {

    @Test
    public void createdWorldShouldNotBeNull() {

        /* Given, When */
        World sut = World.builder().id(1).name("Test").build();

        /* Then */
        assertNotNull(sut);
    }

    @Test
    public void createdWorldShouldHaveCorrectValues() {

        /* Given, When */
        World sut = World.builder().id(1).name("Test").build();

        /* Then */
        assertEquals(1, sut.getId());
        assertEquals("Test", sut.getName());
    }

    @Test
    public void playerSpawnedAtCenterIsInCorrectRegion() {

        World sut = World.builder().id(1).name("Test").regionGridSideLength(3).build();

        PlayerGenerator playerGenerator = new PlayerGenerator();

        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        WorldGenerator worldGenerator = new WorldGenerator();

        worldGenerator.generateRegions(sut);

        /* When */
        sut.spawnPlayerAtCenter(player);

        /* Then */
        assertEquals(new Coordinate(1, 1), player.getCurrentPosition());
    }
}