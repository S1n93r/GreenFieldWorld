package com.slinger.greenfieldworld.controller.inputparser;

import com.slinger.greenfieldworld.controller.inputparser.subparser.*;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

public class InputParser {

    public static final String UNKNOWN_COMMAND = "Command '{0}' is not a valid. Try 'help'.";

    private final Map<String, Parser> parserMap = new HashMap<>();

    private final Consumer<String> submitOutputConsumer;

    public InputParser(@NonNull Player player, @NonNull Consumer<String> submitOutputConsumer) {

        this.submitOutputConsumer = submitOutputConsumer;

        parserMap.put("help", new HelpParser(submitOutputConsumer));
        parserMap.put("move", new MoveParser(submitOutputConsumer, player));
        parserMap.put("look", new LookParser(submitOutputConsumer, player));
        parserMap.put("check", new CheckParser(submitOutputConsumer, player));
        parserMap.put("equip", new EquipParser(submitOutputConsumer, player));
    }

    public void submitInput(String input) {

        String[] words = input.split("\\s");

        String firstWord = words.length == 0 ? input : words[0];

        Parser parser = parserMap.get(firstWord.toLowerCase(Locale.ROOT));

        if (parser != null)
            parser.parse(words);

        submitOutputConsumer.accept(MessageUtil.format(UNKNOWN_COMMAND, input));
    }
}