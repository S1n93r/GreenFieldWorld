package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.world.events.Event;
import lombok.NonNull;

import java.util.Optional;
import java.util.function.Consumer;

public class LookParser extends Parser {

    protected static final String NO_PARAM_PROMPT = "Look where?";
    protected static final String NO_EVENT_PROMPT = "You don't see anything of interest.";
    protected static final String DIRECTION_NOT_FOUND_PROMPT = "You should try to look elsewhere.";
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

        switch (paramWord) {

            case "north":
            case "east":
            case "south":
            case "west":
                String output = player.getAction(actionWord).use(paramWord);

                submitOutputConsumer.accept(output);

                break;

            case "around":
                /* TODO: This should start the action, which should then trigger the event. */
                Optional<Event> eventOptional = player.getRegion().getRandomEvent();
                if (eventOptional.isEmpty())
                    submitOutputConsumer.accept(NO_EVENT_PROMPT);
                else
                    submitOutputConsumer.accept(eventOptional.get().begin());
                break;

            default:
                submitOutputConsumer.accept(DIRECTION_NOT_FOUND_PROMPT);
        }
    }
}