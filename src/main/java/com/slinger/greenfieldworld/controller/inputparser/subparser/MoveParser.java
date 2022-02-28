package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;

import java.util.function.Consumer;

public class MoveParser extends Parser {

    private final Player player;

    public MoveParser(Consumer<String> submitOutputConsumer, Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] params) {

        if (params.length == 1) {
            submitOutputConsumer.accept("Which direction? Try 'north', 'east', 'south' or 'west'.");
            return;
        }

        String firstParam = params[0];
        String secondParam = params[1];

        switch (secondParam) {

            case "north":
            case "east":
            case "south":
            case "west":

                String output = player.getAction(firstParam).use(secondParam);

                submitOutputConsumer.accept(output);
                break;

            default:
                submitOutputConsumer.accept("You can go north, east, south or west.");
        }
    }
}