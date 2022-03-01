package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.world.events.Event;
import lombok.NonNull;

import java.util.Optional;
import java.util.function.Consumer;

public class LookParser extends Parser {

    protected static final String NO_PARAM_PROMPT = "Look where?";

    private final Player player;

    public LookParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

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

        Action look = player.getAction(actionWord);

        if (look == null) {
            submitOutputConsumer.accept("You don't know how to look.");
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

            case "around":
                Optional<Event> eventOptional = player.getRegion().getRandomEvent();
                if (eventOptional.isEmpty())
                    submitOutputConsumer.accept("You don't see anything of interest.");
                else
                    submitOutputConsumer.accept(eventOptional.get().begin());
                break;

            default:
                submitOutputConsumer.accept("You can look north, east, south or west.");
        }
    }
}