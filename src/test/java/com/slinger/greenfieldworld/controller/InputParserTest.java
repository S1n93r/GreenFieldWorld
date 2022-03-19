package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.controller.inputparser.InputParser;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class InputParserTest {

    @Test
    public void unknownCommandTriggersHelpPrompt() {

        /* Given */
        Player playerMock = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        InputParser sut = new InputParser(playerMock, outputProperty::setValue);

        String input = "gibberish";

        /* When */
        sut.submitInput(input);

        /* Then */
        String expectedOutput = MessageUtil.format(InputParser.UNKNOWN_COMMAND, input);

        assertEquals(expectedOutput, outputProperty.get());
    }
}