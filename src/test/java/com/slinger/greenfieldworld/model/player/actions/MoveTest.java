package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.player.actions.move.Move;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MoveTest {

    @Test
    public void triggerWordIsCorrect() {

        /* Given */
        Player player = mock(Player.class);

        /* When */
        Move sut = new Move(player);

        /* Then */
        assertEquals("move", sut.getTriggerWord());
    }

    @Test
    public void usingMoveToChangePlayerPosition() {

        /* Given */
        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Testopia", 5);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(player);

        Move sut = new Move(player);

        /* When */
        sut.use("north");
        Coordinate coordinateAfterMovingNorth = player.getRegion().getCoordinate().copy();

        sut.use("east");
        Coordinate coordinateAfterMovingEast = player.getRegion().getCoordinate().copy();

        sut.use("south");
        Coordinate coordinateAfterMovingSouth = player.getRegion().getCoordinate().copy();

        sut.use("west");
        Coordinate coordinateAfterMovingWest = player.getRegion().getCoordinate().copy();

        sut.use("unknown");
        Coordinate coordinateAfterNotMoving = player.getRegion().getCoordinate().copy();

        /* Then */
        assertEquals(Coordinate.of(2, 1), coordinateAfterMovingNorth);
        assertEquals(Coordinate.of(3, 1), coordinateAfterMovingEast);
        assertEquals(Coordinate.of(3, 2), coordinateAfterMovingSouth);
        assertEquals(Coordinate.of(2, 2), coordinateAfterMovingWest);
        assertEquals(Coordinate.of(2, 2), coordinateAfterNotMoving);
    }
}