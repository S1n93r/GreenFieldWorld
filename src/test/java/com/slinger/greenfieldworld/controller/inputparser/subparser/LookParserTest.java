package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LookParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] params = {"look"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        LookParser sut = new LookParser(outputProperty::set, player);

        /* When */
        sut.parse(params);

        /* Then */
        assertEquals(LookParser.NO_PARAM_PROMPT, outputProperty.get());
    }
}