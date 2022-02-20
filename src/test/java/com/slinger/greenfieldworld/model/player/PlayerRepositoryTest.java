package com.slinger.greenfieldworld.model.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerRepositoryTest {

    @Test
    public void saveStateToFile() {

        /* Given */
        PlayerRepository sut = new PlayerRepository();

        sut.createPlayer("Test 1");
        sut.createPlayer("Test 2");
        sut.createPlayer("Test 3");

        /* When */
        String json = sut.saveStateToFile();

        /* Then */
        assertEquals("", json);
    }
}