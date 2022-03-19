package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class CheckParser extends Parser {

    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "You don't know how to look.";
    protected static final String NO_PARAM_PROMPT = "Check what?";
    protected static final String PARAM_NOT_FOUND_PROMPT = "You don't know how to check '{0}'";

    private final Player player;

    public CheckParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        String actionWord = words[0];

        Action check = player.getAction(actionWord);

        if (check == null) {
            submitOutputConsumer.accept(ACTION_NOT_AVAILABLE_PROMPT);
            return;
        }

        if (words.length == 1) {
            submitOutputConsumer.accept(NO_PARAM_PROMPT);
            return;
        }

        String paramWords = words[1];

        switch (paramWords) {

            case "status":
            case "inventory":
                check.use(paramWords);
                break;

            default:
                submitOutputConsumer.accept(MessageUtil.format(PARAM_NOT_FOUND_PROMPT, paramWords));
        }
    }
}