package com.slinger.greenfieldworld.model.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerTest {

    @Test
    public void createdPlayerIsNotNull() {

        /* Given */
        Player sut = Player.builder().build();

        /* Then */
        assertNotNull(sut);
    }

    @Test
    public void createdPlayerHasValuesFromBuilder() {

        /* Given */
        Player sut = Player.builder()
                .playerId(PlayerId.of(1))
                .playerName(PlayerName.of("Sl1ng3r"))
                .build();

        /* Then */
        assertEquals(1, sut.getPlayerId().getId());
        assertEquals("Sl1ng3r", sut.getPlayerName().getName());
    }
}