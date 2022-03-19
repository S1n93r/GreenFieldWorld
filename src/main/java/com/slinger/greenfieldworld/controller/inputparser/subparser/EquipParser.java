package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import lombok.NonNull;

import java.util.function.Consumer;

public class EquipParser extends Parser {

    protected static final String ACTION_NOT_AVAILABLE_PROMPT = "You don't know how to look.";
    protected static final String NO_PARAM_PROMPT = "Check what?";

    private final Player player;

    public EquipParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        String actionWord = words[0];

        Action equip = player.getAction(actionWord);

        if (equip == null) {
            submitOutputConsumer.accept(ACTION_NOT_AVAILABLE_PROMPT);
            return;
        }

        if (words.length == 1) {
            submitOutputConsumer.accept(NO_PARAM_PROMPT);
            return;
        }

        submitOutputConsumer.accept(equip.use(words[1]));
    }
}