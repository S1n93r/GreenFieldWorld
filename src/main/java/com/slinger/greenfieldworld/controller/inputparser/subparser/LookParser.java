package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;

import java.util.function.Consumer;

public class LookParser extends Parser {

    private final Player player;

    public LookParser(Consumer<String> submitOutputConsumer, Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {

        if (words.length == 1) {
            submitOutputConsumer.accept("Which direction? Try 'north', 'east', 'south' or 'west'.");
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

            default:
                submitOutputConsumer.accept("You can look north, east, south or west.");
        }
    }
}