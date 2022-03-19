package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.player.actions.check.CheckParam;
import lombok.NonNull;

import java.util.function.Consumer;

public class CheckParser extends Parser {

    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "Your are unable to check.";
    protected static final String NO_PARAM_PROMPT = "Check what?";
    protected static final String PARAM_NOT_FOUND_PROMPT = "You don't know how to check '{0}'";
    protected static final String ACTION_PARAM_NOT_IMPLEMENTED = "WARNING: Action parameter not implemented.";

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

        CheckParam checkParam = CheckParam.fromString(paramWords);

        switch (checkParam) {

            case INVENTORY:
                submitOutputConsumer.accept(check.use(paramWords));
                break;

            case LOOT:
            case STATUS:
                submitOutputConsumer.accept(ACTION_PARAM_NOT_IMPLEMENTED);
                break;

            default:
                submitOutputConsumer.accept(MessageUtil.format(PARAM_NOT_FOUND_PROMPT, paramWords));
        }
    }
}