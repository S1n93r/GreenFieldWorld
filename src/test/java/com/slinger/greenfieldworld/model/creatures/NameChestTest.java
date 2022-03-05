package com.slinger.greenfieldworld.model.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NameChestTest {

    @Test
    public void test() {

        /* Given */
        NameChest sut = new NameChest("Name A", "Name B", "Name C");

        /* When */
        String actualName = sut.giveRandomName();

        /* Then */
        boolean randomNameIsGivenName =
                actualName.equals("Name A") || actualName.equals("Name B") || actualName.equals("Name C");

        assertTrue(randomNameIsGivenName);
    }
}