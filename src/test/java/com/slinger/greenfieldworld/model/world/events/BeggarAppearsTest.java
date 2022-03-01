package com.slinger.greenfieldworld.model.world.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BeggarAppearsTest {

    @Test
    public void beginTriggersBeggarPrompt() {

        /* Given */
        BeggarAppears sut = new BeggarAppears(100);

        /* When */
        String prompt = sut.begin();

        /* Then */
        assertEquals(BeggarAppears.BEGGAR_APPEARS_PROMPT, prompt);
    }
}