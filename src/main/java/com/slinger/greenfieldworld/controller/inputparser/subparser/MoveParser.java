package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class MoveParser extends Parser {

    protected static final String NO_PARAM_PROMPT = "Move where?";

    private final Player player;

    public MoveParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        if (words.length == 1) {
            submitOutputConsumer.accept(NO_PARAM_PROMPT);
            return;
        }

        String actionWord = words[0];
        String paramWord = words[1];

        Action move = player.getAction(actionWord);

        if (move == null) {
            submitOutputConsumer.accept("You don't know how to move.");
            return;
        }

        switch (paramWord) {

            case "north":
            case "east":
            case "south":
            case "west":
                String output = player.getAction(actionWord).use(paramWord);

                submitOutputConsumer.accept(output);

                break;

            case "to":
                break;

            default:
                submitOutputConsumer.accept("You can go north, east, south or west.");
        }
    }
}