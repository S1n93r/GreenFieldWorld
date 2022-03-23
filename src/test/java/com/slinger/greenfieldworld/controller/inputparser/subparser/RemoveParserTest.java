package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.unequip.Remove;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.slinger.greenfieldworld.controller.inputparser.subparser.RemoveParser.NO_PARAM_PROMPT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class RemoveParserTest {

    @Test
    public void parsingWithoutKnowingActionTriggersPrompt() {

        /* Given */
        String[] words = {"remove"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        EquipParser sut = new EquipParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(EquipParser.ACTION_NOT_AVAILABLE_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] paramWords = {"remove"};

        Inventory inventoryMock = mock(Inventory.class);

        Player playerMock = mock(Player.class);
        Mockito.when(playerMock.getAction("remove")).thenReturn(new Remove(playerMock, inventoryMock));

        StringProperty stringProperty = new SimpleStringProperty();

        RemoveParser sut = new RemoveParser(stringProperty::set, playerMock);

        /* When */
        sut.parse(paramWords);

        /* Then */
        assertEquals(NO_PARAM_PROMPT, stringProperty.getValue());
    }

    @Test
    public void parsingWithParamTriggersPrompt() {

        /* Given */
        String[] paramWords = {"remove", "unknown"};

        Inventory inventoryMock = mock(Inventory.class);

        Player playerMock = mock(Player.class);
        Mockito.when(playerMock.getAction("remove")).thenReturn(new Remove(playerMock, inventoryMock));

        StringProperty stringProperty = new SimpleStringProperty();

        RemoveParser sut = new RemoveParser(stringProperty::set, playerMock);

        /* When */
        sut.parse(paramWords);

        /* Then */
        assertEquals("You don't know how to remove 'unknown'.", stringProperty.getValue());
    }
}