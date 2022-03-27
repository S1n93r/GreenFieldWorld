package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.gather.Gather;
import com.slinger.greenfieldworld.model.player.actions.gather.GatherParam;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class GatherParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] words = {"gather"};

        Inventory inventory = mock(Inventory.class);

        Player player = mock(Player.class);
        Mockito.when(player.getAction("gather")).thenReturn(new Gather(player, inventory));

        final StringProperty outputProperty = new SimpleStringProperty();

        GatherParser sut = new GatherParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(GatherParser.NO_PARAM_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutKnowingActionTriggersPrompt() {

        /* Given */
        String[] words = {"gather"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        GatherParser sut = new GatherParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(GatherParser.ACTION_NOT_AVAILABLE_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithUnknownParamTriggersPrompt() {

        /* Given */
        String[] words = {"gather", "unknown"};

        Inventory inventory = mock(Inventory.class);

        Player player = mock(Player.class);
        Mockito.when(player.getAction("gather")).thenReturn(new Gather(player, inventory));

        final StringProperty outputProperty = new SimpleStringProperty();

        GatherParser sut = new GatherParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        String expectedOutput = MessageUtil.format(GatherParser.PARAM_NOT_FOUND_PROMPT, GatherParam.UNKNOWN);

        assertEquals(expectedOutput, outputProperty.get());
    }

    @Test
    public void parsingWithKnownParamTriggersPrompt() {

        /* Given */
        String[] words = {"gather", "plants"};

        Inventory inventory = mock(Inventory.class);

        Player player = mock(Player.class);
        Mockito.when(player.getAction("gather")).thenReturn(new Gather(player, inventory));

        final StringProperty outputProperty = new SimpleStringProperty();

        GatherParser sut = new GatherParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        String expectedOutput = MessageUtil.format(GatherParser.ACTION_PARAM_NOT_IMPLEMENTED);

        assertEquals(expectedOutput, outputProperty.get());
    }
}