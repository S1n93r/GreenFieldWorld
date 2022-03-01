package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MoveParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] params = {"move"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        MoveParser sut = new MoveParser(outputProperty::set, player);

        /* When */
        sut.parse(params);

        /* Then */
        String expectedOutput = MoveParser.NO_PARAM_PROMPT;

        assertEquals(expectedOutput, outputProperty.get());
    }
}