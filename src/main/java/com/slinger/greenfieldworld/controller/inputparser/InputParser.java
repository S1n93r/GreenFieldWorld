package com.slinger.greenfieldworld.controller.inputparser;

import com.slinger.greenfieldworld.controller.inputparser.subparser.HelpParser;
import com.slinger.greenfieldworld.controller.inputparser.subparser.LookParser;
import com.slinger.greenfieldworld.controller.inputparser.subparser.MoveParser;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import lombok.NonNull;

import java.util.function.Consumer;

public class InputParser {

    public static final String UNKNOWN_COMMAND = "Command '{0}' is not a valid. Try 'help'.";

    private final HelpParser helpParser;
    private final MoveParser moveParser;
    private final LookParser lookParser;

    private final Consumer<String> submitOutputConsumer;

    public InputParser(@NonNull Player player, @NonNull Consumer<String> submitOutputConsumer) {

        this.submitOutputConsumer = submitOutputConsumer;

        helpParser = new HelpParser(submitOutputConsumer);
        moveParser = new MoveParser(submitOutputConsumer, player);
        lookParser = new LookParser(submitOutputConsumer, player);
    }

    public void submitInput(String input) {

        String[] words = input.split("\\s");

        String firstWord = words.length == 0 ? input : words[0];

        if (firstWord.equalsIgnoreCase("help"))
            helpParser.parse(null);
        else if (firstWord.equalsIgnoreCase("move"))
            moveParser.parse(words);
        else if (firstWord.equalsIgnoreCase("look"))
            lookParser.parse(words);
        else
            submitOutputConsumer.accept(MessageUtil.format(UNKNOWN_COMMAND, input));
    }
}