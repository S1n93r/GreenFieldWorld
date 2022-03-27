package com.slinger.greenfieldworld.model.player.actions.gather;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GatherTest {

    @Test
    public void checkingOnEmptyInventoriesReturnsSpecificOutput() {

        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        String output = player.getAction("gather").use("plants");

        /* TODO: Implement tests */

        assertEquals("", output);
    }
}