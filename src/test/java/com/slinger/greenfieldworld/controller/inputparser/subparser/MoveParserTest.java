package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Move;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class MoveParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] params = {"move"};

        Player player = mock(Player.class);
        Mockito.when(player.getAction("move")).thenReturn(new Move(player));

        final StringProperty outputProperty = new SimpleStringProperty();

        MoveParser sut = new MoveParser(outputProperty::set, player);

        /* When */
        sut.parse(params);

        /* Then */
        assertEquals(MoveParser.NO_PARAM_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutKnowingActionTriggersPrompt() {

        /* Given */
        String[] words = {"move"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        MoveParser sut = new MoveParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(MoveParser.ACTION_NOT_AVAILABLE_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithUnknownDirectionTriggersPrompt() {

        /* Given */
        String[] words = {"move", "unknown"};

        Player player = mock(Player.class);
        Mockito.when(player.getAction("move")).thenReturn(new Move(player));

        final StringProperty outputProperty = new SimpleStringProperty();

        MoveParser sut = new MoveParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(MoveParser.DIRECTION_NOT_FOUND_PROMPT, outputProperty.get());
    }
}