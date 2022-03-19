package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.look.Look;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LookParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] words = {"look"};

        Player player = mock(Player.class);
        Mockito.when(player.getAction("look")).thenReturn(new Look(player));

        final StringProperty outputProperty = new SimpleStringProperty();

        LookParser sut = new LookParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(LookParser.NO_PARAM_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutKnowingActionTriggersPrompt() {

        /* Given */
        String[] words = {"look"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        LookParser sut = new LookParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(LookParser.ACTION_NOT_AVAILABLE_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithUnknownDirectionTriggersPrompt() {

        /* Given */
        String[] words = {"look", "unknown"};

        Player player = mock(Player.class);
        Mockito.when(player.getAction("look")).thenReturn(new Look(player));

        final StringProperty outputProperty = new SimpleStringProperty();

        LookParser sut = new LookParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals("You don't know how to look towards 'unknown'", outputProperty.get());
    }
}