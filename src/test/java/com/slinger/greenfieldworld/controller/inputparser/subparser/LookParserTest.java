package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Look;
import com.slinger.greenfieldworld.model.world.regions.Plains;
import com.slinger.greenfieldworld.model.world.regions.Region;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

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
        assertEquals(LookParser.DIRECTION_NOT_FOUND_PROMPT, outputProperty.get());
    }

    @Test
    public void parsingWithoutEventTriggersPrompt() {

        /* Given */
        String[] words = {"look", "around"};

        Region region = mock(Plains.class);
        Mockito.when(region.getRandomEvent()).thenReturn(Optional.empty());

        Player player = mock(Player.class);
        Mockito.when(player.getAction("look")).thenReturn(new Look(player));
        Mockito.when(player.getRegion()).thenReturn(region);

        final StringProperty outputProperty = new SimpleStringProperty();

        LookParser sut = new LookParser(outputProperty::set, player);

        /* When */
        sut.parse(words);

        /* Then */
        assertEquals(LookParser.NO_EVENT_PROMPT, outputProperty.get());
    }
}