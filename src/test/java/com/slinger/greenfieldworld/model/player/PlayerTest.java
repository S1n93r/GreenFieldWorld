package com.slinger.greenfieldworld.model.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerTest {

    @Test
    public void createdPlayerIsNotNull() {

        /* Given */
        Player sut = new Player("Sl1ng3r");

        /* Then */
        assertNotNull(sut);
    }

    @Test
    public void createdPlayerHasValuesFromBuilder() {

        /* Given */
        Player sut = new Player("Sl1ng3r");

        /* Then */
        assertEquals("Sl1ng3r", sut.getName());
    }
}