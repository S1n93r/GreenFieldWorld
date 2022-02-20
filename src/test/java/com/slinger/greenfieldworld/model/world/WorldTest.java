package com.slinger.greenfieldworld.model.world;

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
}