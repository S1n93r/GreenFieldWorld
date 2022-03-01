package com.slinger.greenfieldworld.model.world.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EventChestTest {

    @Test
    public void getRandomEventOnOneHundredPercentIsNeverEmpty() {

        EventChest eventChest = new EventChest();

        eventChest.addEvent(new BeggarAppears(100));

        assertFalse(eventChest.getRandomEvent().isEmpty());
        assertFalse(eventChest.getRandomEvent().isEmpty());
        assertFalse(eventChest.getRandomEvent().isEmpty());
    }

    @Test
    public void gentRandomEventOnZeroPercentIsAlwaysEmpty() {

        EventChest eventChest = new EventChest();

        eventChest.addEvent(new BeggarAppears(0));
        eventChest.addEvent(new BeggarAppears(0));
        eventChest.addEvent(new BeggarAppears(0));

        assertTrue(eventChest.getRandomEvent().isEmpty());
        assertTrue(eventChest.getRandomEvent().isEmpty());
        assertTrue(eventChest.getRandomEvent().isEmpty());
    }
}