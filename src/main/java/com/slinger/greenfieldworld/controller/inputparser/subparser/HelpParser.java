package com.slinger.greenfieldworld.controller.inputparser.subparser;

import lombok.NonNull;

import java.util.function.Consumer;

public class HelpParser extends Parser {

    protected static final String SEPARATOR = "--------------------";

    protected static final String HELP_PROMPT = SEPARATOR + System.lineSeparator()
            + "help - shows basic commands" + System.lineSeparator()
            + "move - move you character north, east, south or west" + System.lineSeparator()
            + "look - makes your character look north, east, south or west" + System.lineSeparator()
            + "check - check an item or your inventory" + System.lineSeparator()
            + "" + System.lineSeparator()
            + "It is up to you to find out more commands =)." + System.lineSeparator()
            + SEPARATOR;

    public HelpParser(@NonNull Consumer<String> submitOutputConsumer) {
        super(submitOutputConsumer);
    }

    @Override
    public void parse(String[] params) {
        submitOutputConsumer.accept(HELP_PROMPT);
    }
}