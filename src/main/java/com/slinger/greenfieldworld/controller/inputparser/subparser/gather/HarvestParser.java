package com.slinger.greenfieldworld.controller.inputparser.subparser.gather;

import com.slinger.greenfieldworld.controller.inputparser.subparser.Parser;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class HarvestParser extends Parser {

    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "Your are unable to harvest anything.";
    protected static final String NO_PARAM_PROMPT = "Harvest what?";
    protected static final String PARAM_NOT_FOUND_PROMPT = "You don't know how to harvest that.";
    protected static final String ACTION_PARAM_NOT_IMPLEMENTED = "WARNING: Action parameter not implemented.";

    private final Player player;

    public HarvestParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        String actionWord = words[0];

        Action harvest = player.getAction(actionWord);

        if (harvest == null) {
            submitOutputConsumer.accept(ACTION_NOT_AVAILABLE_PROMPT);
            return;
        }

        if (words.length == 2) {
            submitOutputConsumer.accept(PARAM_NOT_FOUND_PROMPT);
            return;
        }

        submitOutputConsumer.accept(harvest.use(""));
    }
}