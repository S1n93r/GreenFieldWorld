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
                .id(1)
                .name("Sl1ng3r")
                .build();

        /* Then */
        assertEquals(1, sut.getId());
        assertEquals("Sl1ng3r", sut.getName());
    }
}