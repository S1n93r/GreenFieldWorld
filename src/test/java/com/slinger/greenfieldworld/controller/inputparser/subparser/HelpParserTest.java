package com.slinger.greenfieldworld.controller.inputparser.subparser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelpParserTest {

    @Test
    public void parsingTriggersHelpPrompt() {

        final StringProperty outputProperty = new SimpleStringProperty();

        HelpParser helpParser = new HelpParser(outputProperty::set);

        helpParser.parse(null);

        String expectedOutput = HelpParser.SEPARATOR + System.lineSeparator()
                + "help - shows basic commands" + System.lineSeparator()
                + "move - move you character north, east, south or west" + System.lineSeparator()
                + "look - makes your character look north, east, south or west" + System.lineSeparator()
                + "check - check an item or your inventory" + System.lineSeparator()
                + "" + System.lineSeparator()
                + "It is up to you to find out more commands =)." + System.lineSeparator()
                + HelpParser.SEPARATOR;

        assertEquals(expectedOutput, outputProperty.get());
    }
}