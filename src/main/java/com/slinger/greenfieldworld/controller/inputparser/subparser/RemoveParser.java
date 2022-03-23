package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class RemoveParser extends Parser {

    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "Your are unable to remove.";
    protected static final String NO_PARAM_PROMPT = "Remove what?";

    private final Player player;

    public RemoveParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        String actionWord = words[0];

        Action remove = player.getAction(actionWord);

        if (remove == null) {
            submitOutputConsumer.accept(ACTION_NOT_AVAILABLE_PROMPT);
            return;
        }

        if (words.length == 1) {
            submitOutputConsumer.accept(NO_PARAM_PROMPT);
            return;
        }

        submitOutputConsumer.accept(remove.use(words[1]));
    }
}