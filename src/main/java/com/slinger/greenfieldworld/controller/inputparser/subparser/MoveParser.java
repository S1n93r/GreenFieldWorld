package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class MoveParser extends Parser {

    protected static final String NO_PARAM_PROMPT = "Move where?";
    protected static final String NO_EVENT_PROMPT = "You move without any interruptions.";
    protected static final String DIRECTION_NOT_FOUND_PROMPT = "You should try to look elsewhere.";
    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "You don't know how to move.";
    private final Player player;

    public MoveParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        String actionWord = words[0];

        Action move = player.getAction(actionWord);

        if (move == null) {
            submitOutputConsumer.accept(ACTION_NOT_AVAILABLE_PROMPT);
            return;
        }

        if (words.length == 1) {
            submitOutputConsumer.accept(NO_PARAM_PROMPT);
            return;
        }

        String paramWord = words[1];

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
                submitOutputConsumer.accept(DIRECTION_NOT_FOUND_PROMPT);
        }
    }
}