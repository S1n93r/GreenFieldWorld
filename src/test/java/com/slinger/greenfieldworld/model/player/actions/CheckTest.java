package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckTest {

    @Test
    public void checkingOnEmptyInventoriesReturnsSpecificOutput() {

        PlayerGenerator generator = new PlayerGenerator();
        Player player = generator.generatePlayer("Sl1ng3r");

        String output = player.getAction("check").use("inventory");

        String expectedOutput = "Backpack:" + System.lineSeparator()
                + "----------" + System.lineSeparator()
                + "You don't have a backpack." + System.lineSeparator()
                + "----------" + System.lineSeparator()
                + System.lineSeparator()
                + "Belt bag:" + System.lineSeparator()
                + "----------" + System.lineSeparator()
                + "You don't have a belt bag." + System.lineSeparator()
                + "----------" + System.lineSeparator();

        assertEquals(expectedOutput, output);
    }
}