package com.slinger.greenfieldworld.model.player;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.Direction;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerTest {

    @Test
    public void createdPlayerIsNotNull() {

        /* Given */
        Player sut = Player.builder().name("Sl1ng3r").build();

        /* Then */
        assertNotNull(sut);
    }

    @Test
    public void createdPlayerHasValuesFromBuilder() {

        /* Given */
        Player sut = Player.builder().name("Sl1ng3r").build();

        /* Then */
        assertEquals("Sl1ng3r", sut.getName());
    }

    @Test
    public void movePlayer() {

        /* Given */
        WorldGenerator worldGenerator = new WorldGenerator();

        World world = worldGenerator.generateWorld("Test", 3);

        PlayerGenerator playerGenerator = new PlayerGenerator();

        Player sut = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(sut);

        /* When */
        sut.move(world, Direction.NORTH);

        /* Then */
        assertEquals(Coordinate.of(1, 0), sut.getCurrentRegion().getCoordinate());
    }
}