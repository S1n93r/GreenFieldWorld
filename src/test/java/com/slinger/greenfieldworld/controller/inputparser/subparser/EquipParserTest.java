package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Equip;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class EquipParserTest {

    @Test
    public void parsingWithoutParamsTriggersPrompt() {

        /* Given */
        String[] words = {"equip"};

        Inventory inventory = mock(Inventory.class);

        Player player = mock(Player.class);
        Mockito.when(player.getAction("equip")).thenReturn(new Equip(player, inventory));

        final StringProperty outputProperty = new SimpleStringProperty();

        EquipParser sut = new EquipParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(EquipParser.NO_PARAM_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutKnowingActionTriggersPrompt() {

        /* Given */
        String[] words = {"equip"};

        Player player = mock(Player.class);

        final StringProperty outputProperty = new SimpleStringProperty();

        EquipParser sut = new EquipParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(EquipParser.ACTION_NOT_AVAILABLE_PROMPT, outputProperty.get());
    }
}