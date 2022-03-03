package com.slinger.greenfieldworld.model.world.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeggarEventTest {

    @Test
    public void beginTriggersBeggarPrompt() {

        /* Given */
        BeggarEvent sut = new BeggarEvent(100);

        /* When */
        String prompt = sut.begin();

        /* Then */
        assertEquals(BeggarEvent.BEGGAR_PROMPT, prompt);
    }
}