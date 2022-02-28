package com.slinger.greenfieldworld.model.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerGeneratorTest {

    @Test
    public void generatedPlayerIsNotNull() {

        /* Given */
        PlayerGenerator sut = new PlayerGenerator();

        /* When */
        Player player = sut.generatePlayer("Sl1ng3r");

        /* Then */
        assertNotNull(player);
    }

    @Test
    public void generatedPlayerHasCorrectName() {

        /* Given */
        PlayerGenerator sut = new PlayerGenerator();

        /* When */
        Player player = sut.generatePlayer("Sl1ng3r");

        /* Then */
        assertNotNull("Sl1ng3r", player.getName());
    }
}