package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Check;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CheckParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] words = {"check"};

        Inventory inventory = mock(Inventory.class);

        Player player = mock(Player.class);
        Mockito.when(player.getAction("check")).thenReturn(new Check(player, inventory));

        final StringProperty outputProperty = new SimpleStringProperty();

        CheckParser sut = new CheckParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(CheckParser.NO_PARAM_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutKnowingActionTriggersPrompt() {

        /* Given */
        String[] words = {"check"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        CheckParser sut = new CheckParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(CheckParser.ACTION_NOT_AVAILABLE_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithUnknownParamsTriggersPrompt() {

        /* Given */
        String[] words = {"check", "unknown"};

        Inventory inventory = mock(Inventory.class);

        Player player = mock(Player.class);
        Mockito.when(player.getAction("check")).thenReturn(new Check(player, inventory));

        final StringProperty outputProperty = new SimpleStringProperty();

        CheckParser sut = new CheckParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        String expectedOutput = MessageUtil.format(CheckParser.PARAM_NOT_FOUND_PROMPT, words[1]);

        assertEquals(expectedOutput, outputProperty.get());
    }
}