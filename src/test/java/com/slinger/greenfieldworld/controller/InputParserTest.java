package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputParserTest {

    @Test
    public void submitInputTriggersOutputConsumer() {

        /* Given */
        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Test", 10);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        Property<String> outputProperty = new SimpleStringProperty();

        InputParser sut = new InputParser(player, world, outputProperty::setValue);

        /* When */
        sut.submitInput("move");

        /* Then */
        String actualOutput = outputProperty.getValue();

        assertEquals("Which direction?", actualOutput);
    }
}