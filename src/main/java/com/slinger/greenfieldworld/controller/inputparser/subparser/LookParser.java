package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class LookParser extends Parser {

    protected static final String NO_PARAM_PROMPT = "Look where?";
    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "You don't know how to look.";

    private final Player player;

    public LookParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        String actionWord = words[0];

        Action look = player.getAction(actionWord);

        if (look == null) {
            submitOutputConsumer.accept(ACTION_NOT_AVAILABLE_PROMPT);
            return;
        }

        if (words.length == 1) {
            submitOutputConsumer.accept(NO_PARAM_PROMPT);
            return;
        }

        String paramWord = words[1];

        submitOutputConsumer.accept(player.getAction(actionWord).use(paramWord));
    }
}