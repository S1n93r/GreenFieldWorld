package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.world.World;
import lombok.Getter;
import lombok.NonNull;

import java.util.function.Consumer;

public class InputParser {

    public static final String UNKNOWN_COMMAND = "Command '{0}' is not a valid. Try 'help'.";

    private static final String SEPARATOR = "--------------------";

    private final Player player;
    private final World world;

    private final Consumer<String> submitOutputConsumer;

    @Getter
    private String currentOutput;

    public InputParser(@NonNull Player player, @NonNull World world, @NonNull Consumer<String> submitOutputConsumer) {
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
            submitOutput(UNKNOWN_COMMAND, input);
    }

    /* TODO: Extract this to separate class. */
    private void help() {

        String availableCommands = SEPARATOR + System.lineSeparator()
                + "help - shows basic commands" + System.lineSeparator()
                + "move - move you character north, east, south or west" + System.lineSeparator()
                + "look - makes your character look north, east, south or west" + System.lineSeparator()
                + "check - check an item or your inventory" + System.lineSeparator()
                + "" + System.lineSeparator()
                + "It is up to you to find out more commands =)." + System.lineSeparator()
                + SEPARATOR;

        submitOutput(availableCommands);
    }

    /* TODO: Extract this to separate class. */
    public void move(String[] inputParams) {

        if (inputParams.length == 1) {
            submitOutput("Which direction? Try 'north', 'east', 'south' or 'west'.");
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

                submitOutput(output);
                break;

            default:
                submitOutput("You can go north, east, south or west.");
        }
    }

    private void submitOutput(String output, Object... args) {
        currentOutput = MessageUtil.format(output, args);
        submitOutputConsumer.accept(MessageUtil.format(output, args));
    }
}