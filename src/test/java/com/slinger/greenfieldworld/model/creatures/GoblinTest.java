package com.slinger.greenfieldworld.model.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GoblinTest {

    @Test
    public void createdGoblinHasRandomName() {

        /* Given, When */
        Goblin sut = new Goblin();

        /* Then */
        assertFalse(sut.getName().isEmpty());
    }

    @Test
    public void createdGoblinHasAttributesInCorrectRange() {

        /* Given, When */
        Goblin sut = new Goblin();

        /* Then */
        assertTrue(sut.getAttack() >= 1);
        assertTrue(sut.getAttack() <= 2);

        assertTrue(sut.getDefense() >= 1);
        assertTrue(sut.getDefense() <= 2);

        assertTrue(sut.getConstitution() >= 1);
        assertTrue(sut.getConstitution() <= 2);

        assertTrue(sut.getMorale() >= 1);
        assertTrue(sut.getMorale() <= 2);
    }
}