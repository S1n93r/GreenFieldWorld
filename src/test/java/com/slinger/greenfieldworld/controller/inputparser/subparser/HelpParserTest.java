package com.slinger.greenfieldworld.controller.inputparser.subparser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelpParserTest {

    @Test
    public void parsingTriggersHelpPrompt() {

        /* Given */
        final StringProperty outputProperty = new SimpleStringProperty();

        HelpParser sut = new HelpParser(outputProperty::set);

        /* When */
        sut.parse(null);

        /* Then */
        assertEquals(HelpParser.HELP_PROMPT, outputProperty.get());
    }
}