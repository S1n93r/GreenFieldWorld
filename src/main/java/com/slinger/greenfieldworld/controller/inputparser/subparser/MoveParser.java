package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;

import java.util.function.Consumer;

public class MoveParser extends Parser {

    private final Player player;

    public MoveParser(Consumer<String> submitOutputConsumer, Player player) {

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

        Action move = player.getAction(actionWord);

        if (move == null) {
            submitOutputConsumer.accept("You don't know how to move.");
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
                submitOutputConsumer.accept("You can go north, east, south or west.");
        }
    }
}