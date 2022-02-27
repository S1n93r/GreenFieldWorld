package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.world.World;
import lombok.Getter;

import java.util.function.Consumer;

public class InputParser {

    private static final String SEPARATOR = "--------------------";

    private final Player player;
    private final World world;

    private final Consumer<String> submitOutputConsumer;

    @Getter
    private String currentOutput;

    public InputParser(Player player, World world, Consumer<String> submitOutputConsumer) {
        this.player = player;
        this.world = world;
        this.submitOutputConsumer = submitOutputConsumer;
    }

    public void submitInput(String input) {

        String[] words = input.split("\\s");

        String firstWord = words.length == 0 ? input : words[0];

        if (firstWord.equalsIgnoreCase("move"))
            move(words);
        else if (firstWord.equalsIgnoreCase("help"))
            help();
        else
            submitOutputConsumer.accept(MessageUtil.format("Command '{0}' is not a valid. Try 'help'."));
    }

    private void help() {

        String availableCommands = SEPARATOR + System.lineSeparator()
                + "help - shows basic commands" + System.lineSeparator()
                + "move - move you character north, east, south or west" + System.lineSeparator()
                + "look - makes your character look north, east, south or west" + System.lineSeparator()
                + "check - check an item or your inventory" + System.lineSeparator()
                + "" + System.lineSeparator()
                + "It is up to you to find out more commands =)." + System.lineSeparator()
                + SEPARATOR;

        submitOutputConsumer.accept(availableCommands);
    }

    public void move(String[] inputParams) {

        if (inputParams.length == 1) {
            submitOutputConsumer.accept(MessageUtil.format("Which direction? Try 'north', 'east', 'south' or 'west'."));
            return;
        }

        String firstParam = inputParams[0];
        String secondParam = inputParams[1];

        switch (secondParam) {

            case "north":
            case "east":
            case "south":
            case "west":

                String output = player.getAction(firstParam).use(secondParam);

                submitOutputConsumer.accept(output);
                break;

            default:
                submitOutputConsumer.accept(MessageUtil.format("You can go north, east, south or west."));
        }
    }
}