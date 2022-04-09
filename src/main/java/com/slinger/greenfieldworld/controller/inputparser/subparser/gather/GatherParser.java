package com.slinger.greenfieldworld.controller.inputparser.subparser.gather;

import com.slinger.greenfieldworld.controller.inputparser.subparser.Parser;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.player.actions.gather.GatherParam;
import lombok.NonNull;

import java.util.function.Consumer;

public class GatherParser extends Parser {

    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "Your are unable to gather anything.";
    protected static final String NO_PARAM_PROMPT = "Gather what?";
    protected static final String PARAM_NOT_FOUND_PROMPT = "You don't know how to gather '{0}'";
    protected static final String ACTION_PARAM_NOT_IMPLEMENTED = "WARNING: Action parameter not implemented.";

    private final Player player;

    public GatherParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

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

        GatherParam gatherParam = GatherParam.fromString(paramWords);

        switch (gatherParam) {

            case PLANTS:
            case WOOD:
            case ORE:
                submitOutputConsumer.accept(MessageUtil.format(ACTION_PARAM_NOT_IMPLEMENTED));
                break;

            case UNKNOWN:
                submitOutputConsumer.accept(MessageUtil.format(PARAM_NOT_FOUND_PROMPT, gatherParam));
                break;

            default:
                submitOutputConsumer.accept(MessageUtil.format(PARAM_NOT_FOUND_PROMPT, paramWords));
        }
    }
}