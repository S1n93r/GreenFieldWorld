package com.slinger.greenfieldworld.model.player;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MoveTest {

    @Test
    public void triggerWordIsCorrect() {

        Player player = mock(Player.class);

        Move sut = new Move(player);

        assertEquals("move", sut.triggerWord);
    }

    @Test
    public void usingMoveChangesPositionOfPlayer() {

        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Testopia", 5);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(player);

        Move sut = new Move(player);

        sut.use("north");

        assertEquals(Coordinate.of(2, 1), player.getRegion().getCoordinate());
    }
}