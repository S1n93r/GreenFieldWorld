package com.slinger.greenfieldworld.controller.inputparser.subparser;

import java.util.function.Consumer;

public class HelpParser extends Parser {

    protected static final String SEPARATOR = "--------------------";

    public HelpParser(Consumer<String> submitOutputConsumer) {
        super(submitOutputConsumer);
    }

    @Override
    public void parse(String[] params) {

        String availableCommands = SEPARATOR + System.lineSeparator()
                + "help - shows basic commands" + System.lineSeparator()
                + "move - move you character north, east, south or west" + System.lineSeparator()
                + "look - makes your character look north, east, south or west" + System.lineSeparator()
                + "check - check an item or your inventory" + System.lineSeparator()
                + "" + System.lineSeparator()
                + "It is up to you to find out more commands =)." + System.lineSeparator()
                + SEPARATOR;

        submitOutputConsumer.accept(availableCommands);
    }
}